package br.com.jonataslaet.dto.output

import java.math.BigDecimal

data class VendaOutput(
    val cliente: String,
    val veiculo: VeiculoOutput,
    val valor: BigDecimal,
    val parcelas: List<Parcela>
)
