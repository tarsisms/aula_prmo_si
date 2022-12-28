package br.ifal.aula.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.ifal.aula.data.dao.PacoteDao
import br.ifal.aula.domain.Pacote

@Database(entities = [Pacote::class], version = 1)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun pacoteDao() : PacoteDao

    companion object {
        fun getInstance(context: Context) : DatabaseHelper {
            return Room.databaseBuilder(
                context,
                DatabaseHelper::class.java,
                "hurb2.db"
            ).build()
            // .allowMainThreadQueries()
        }
    }

}