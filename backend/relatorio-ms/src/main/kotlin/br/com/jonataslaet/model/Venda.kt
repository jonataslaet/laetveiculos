package br.com.jonataslaet.model

import br.com.jonataslaet.model.annotations.NoArg
import java.math.BigDecimal

@NoArg
data class Venda(
    var cliente: String,
    var veiculo: Veiculo,
    var valor: BigDecimal,
    var parcelas: List<Parcela>
)