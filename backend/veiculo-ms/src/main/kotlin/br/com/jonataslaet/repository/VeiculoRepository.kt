package br.com.jonataslaet.repository

import br.com.jonataslaet.model.Veiculo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface VeiculoRepository: JpaRepository<Veiculo, Long> {
}