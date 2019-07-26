package br.com.twittelumapp.bancodedados

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import br.com.twittelumapp.modelo.Tweet

@Dao
interface TweetDao {
    @Insert
    fun insere(tweet: Tweet)

}