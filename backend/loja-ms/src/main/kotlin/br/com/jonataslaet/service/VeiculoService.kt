package br.com.jonataslaet.service

import br.com.jonataslaet.dto.output.VeiculoOutput
import br.com.jonataslaet.http.VeiculoHttp
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Singleton
class VeiculoService(
    private val veiculoHttp: VeiculoHttp,
    private val objectMapper: ObjectMapper
    ) {

    fun getVeiculo(id: Long): VeiculoOutput {
        val veiculo = veiculoHttp.findById(id)
        gravarCache(veiculo)
        return veiculo
    }

    fun gravarCache(veiculoOutput: VeiculoOutput){
        val jedisPool = JedisPool(JedisPoolConfig(), "127.0.0.1", 6379)
        val jedis = jedisPool.resource;
        val veiculoJSON = objectMapper.writeValueAsString(veiculoOutput)
        jedis.set(veiculoOutput.id.toString(), veiculoJSON)
    }
}