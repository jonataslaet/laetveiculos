package br.com.jonataslaet.service

import br.com.jonataslaet.dto.input.VendaInput
import br.com.jonataslaet.dto.output.Parcela
import br.com.jonataslaet.dto.output.VendaOutput
import br.com.jonataslaet.http.VeiculoHttp
import jakarta.inject.Singleton
import java.time.LocalDate

@Singleton
class VendaService(
    private val veiculoHttp: VeiculoHttp
) {

    fun realizarVenda(vendaInput: VendaInput) {
        val veiculo = veiculoHttp.findById(vendaInput.veiculo)
        var parcelas: List<Parcela> = ArrayList<Parcela>()
        var valorParcela = vendaInput.valor.divide(vendaInput.quantidadeParcelas.toBigDecimal())
        var dataVencimento = LocalDate.now().plusMonths(1)

        for (i in 1 .. vendaInput.quantidadeParcelas){
            var parcela = Parcela(valorParcela, dataVencimento.toString())
            parcelas = parcelas.plus(parcela)
            dataVencimento = dataVencimento.plusMonths(1)
        }

        var venda = VendaOutput(vendaInput.cliente, veiculo, vendaInput.valor, parcelas)
        println(venda)
    }
}