package br.com.jonataslaet.service

import br.com.jonataslaet.model.Venda
import br.com.jonataslaet.repository.VendaRepository
import jakarta.inject.Singleton

@Singleton
class VendaService(private val vendaRepository: VendaRepository) {

    fun create(venda: Venda){
       vendaRepository.create(venda)
    }
}