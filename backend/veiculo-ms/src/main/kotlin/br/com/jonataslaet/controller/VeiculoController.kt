package br.com.jonataslaet.controller

import br.com.jonataslaet.model.Veiculo
import br.com.jonataslaet.service.VeiculoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/veiculos")
class VeiculoController(
    private val veiculoService: VeiculoService
) {

    @Post
    fun create (@Body veiculo: Veiculo): HttpResponse<Veiculo> {
        val veiculoCriado = veiculoService.create(veiculo)
        return HttpResponse.created(veiculoCriado)
    }

    @Get("/{id}")
    fun findById(@PathVariable id: Long): HttpResponse<Veiculo> {
        val veiculoEncontrado = veiculoService.findById(id)
        return HttpResponse.ok(veiculoEncontrado)
    }
}