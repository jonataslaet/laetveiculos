package br.com.jonataslaet.controller

import br.com.jonataslaet.model.Venda
import br.com.jonataslaet.service.VendaService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/relatorios")
class RelatorioController(
    private val vendaService: VendaService
) {

    @Get
    fun getRelatorio(): List<Venda>{
        return vendaService.getAll()
    }
}