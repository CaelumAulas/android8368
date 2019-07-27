package br.com.twittelumapp.bancodedados

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import br.com.twittelumapp.modelo.Tweet

@Dao
interface TweetDao {
    @Insert
    fun insere(tweet: Tweet)


    @Query("select * from Tweet")
    fun lista(): LiveData<List<Tweet>>

}