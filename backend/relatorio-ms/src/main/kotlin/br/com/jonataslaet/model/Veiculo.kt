package br.com.jonataslaet.model

import br.com.jonataslaet.model.annotations.NoArg

@NoArg
data class Veiculo(
    var id: Long,
    var marca: String,
    var modelo: String,
    var placa: String
)