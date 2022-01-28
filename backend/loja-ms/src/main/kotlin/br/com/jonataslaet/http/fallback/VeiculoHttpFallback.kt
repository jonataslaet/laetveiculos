package br.com.jonataslaet.http.fallback

import br.com.jonataslaet.dto.output.VeiculoOutput
import br.com.jonataslaet.http.VeiculoHttp
import io.micronaut.retry.annotation.Fallback


@Fallback
class VeiculoHttpFallback : VeiculoHttp{
    override fun findById(id: Long): VeiculoOutput {
        return VeiculoOutput(99, "Modelo Bom", "Marca Boa", "KKK3333")
    }
}