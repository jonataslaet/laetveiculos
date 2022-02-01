package br.com.jonataslaet.model

import br.com.jonataslaet.model.annotations.NoArg
import java.math.BigDecimal

@NoArg
data class Parcela(
    var valor: BigDecimal,
    var dataVencimento: String
)