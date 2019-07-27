package br.com.twittelumapp.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import br.com.twittelumapp.TwittelumApplication
import br.com.twittelumapp.bancodedados.TweetDao
import br.com.twittelumapp.bancodedados.TwittelumBancoDeDados
import br.com.twittelumapp.modelo.Tweet

class TweetRepository(private val tweetDao: TweetDao) {

    fun insere(tweet: Tweet)= tweetDao.insere(tweet)

    fun lista(): LiveData<List<Tweet>> = tweetDao.lista()


}