package br.com.jonataslaet.consumer

import br.com.jonataslaet.model.Venda
import br.com.jonataslaet.service.VendaService
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class VendaConsumer(
    private val vendaService: VendaService,
    private val objectMapper: ObjectMapper
) {

    @Topic("ms-vendas")
    fun receberVenda(id: String, vendaJSON: String){
        val venda = objectMapper.readValue(vendaJSON, Venda::class.java)
        vendaService.create(venda)
        println(venda)
    }
}