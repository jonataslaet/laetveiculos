package br.com.jonataslaet.repository

import br.com.jonataslaet.model.Venda
import com.mongodb.client.MongoClient
import com.mongodb.client.result.InsertOneResult
import jakarta.inject.Singleton

@Singleton
class VendaRepository(private val mongoClient: MongoClient) {
    fun create(venda: Venda): InsertOneResult {
        return getConnection().insertOne(venda)
    }

    fun getConnection() = mongoClient
        .getDatabase("vendas")
        .getCollection("venda", Venda::class.java)

    fun getAll(): List<Venda> {
        return getConnection().find().toList()
    }
}