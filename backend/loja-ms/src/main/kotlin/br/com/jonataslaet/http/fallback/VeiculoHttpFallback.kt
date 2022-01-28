package br.com.jonataslaet.http.fallback

import br.com.jonataslaet.dto.output.VeiculoOutput
import br.com.jonataslaet.http.VeiculoHttp
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.retry.annotation.Fallback
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig


@Fallback
class VeiculoHttpFallback (
    private val objectMapper: ObjectMapper
) : VeiculoHttp{
    override fun findById(id: Long): VeiculoOutput {
        val jedisPool = JedisPool(JedisPoolConfig(), "127.0.0.1", 6379)
        val jedis = jedisPool.resource
        val veiculoJson = jedis.get(id.toString())
        val veiculo = objectMapper.readValue(veiculoJson, VeiculoOutput::class.java)
        return veiculo;
    }
}