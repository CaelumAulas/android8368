package br.com.twittelumapp.bancodedados

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.twittelumapp.modelo.Tweet

@Database(entities = [Tweet::class], version = 1)
abstract class TwittelumBancoDeDados : RoomDatabase() {
    abstract fun getTweetDao(): TweetDao


    companion object {
        var banco: TwittelumBancoDeDados? = null

        fun getInstance(contexto: Context):TwittelumBancoDeDados {
           return banco ?: criaNovoBanco(contexto).also { database -> banco = database }
        }

        private fun criaNovoBanco(contexto: Context): TwittelumBancoDeDados {
            val bancoDeDados: TwittelumBancoDeDados =
                Room.databaseBuilder(contexto, TwittelumBancoDeDados::class.java, "TwittelumBD")
                    .allowMainThreadQueries()
                    .build()
            return bancoDeDados
        }
    }
}