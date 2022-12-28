package br.ifal.aula.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Pacote(
    @PrimaryKey(autoGenerate = true) val id : Long = 0L,
    val image: Int,
    val titulo: String,
    val descricao: String,
    val diarias: String,
    val pessoas: String,
    val precoAntigo: Double,
    val precoAtual: Double,
) : Serializable