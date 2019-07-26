package br.com.twittelumapp.repository

import android.app.Application
import br.com.twittelumapp.TwittelumApplication
import br.com.twittelumapp.bancodedados.TwittelumBancoDeDados
import br.com.twittelumapp.modelo.Tweet

class TweetRepository {
    private val application: TwittelumApplication = TwittelumApplication.getInstance()
    private val twittelumBancoDeDados = TwittelumBancoDeDados.getInstance(application)
    private val tweetDao = twittelumBancoDeDados.getTweetDao()

    fun insere(tweet: Tweet)= tweetDao.insere(tweet)

    fun lista(): List<Tweet> = tweetDao.lista()


}