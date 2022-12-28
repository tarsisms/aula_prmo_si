package br.ifal.aula.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.ifal.aula.domain.Pacote

@Dao
interface PacoteDao {

    @Query("SELECT * FROM PACOTE")
    fun findAll() : List<Pacote>

    @Query("SELECT * FROM PACOTE WHERE id = :id")
    fun findById(id : Long) : Pacote?

    @Insert
    fun save(pacote: Pacote)

}