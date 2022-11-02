package br.ifal.aula

import java.io.Serializable

class PacoteTuristico(
    val image: Int,
    val titulo: String,
    val descricao: String,
    val diarias: String,
    val pessoas: String,
    val precoAntigo: Double,
    val precoAtual: Double,
) : Serializable