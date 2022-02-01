package br.com.jonataslaet.http

import br.com.jonataslaet.dto.output.VeiculoOutput
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker

@Client("veiculo-ms")
@CircuitBreaker
interface VeiculoHttp {

    @Get("/veiculos/{id}")
    fun findById(@PathVariable id: Long): VeiculoOutput
}