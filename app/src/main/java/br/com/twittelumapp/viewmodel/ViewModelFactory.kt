package br.com.twittelumapp.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.twittelumapp.TwittelumApplication
import br.com.twittelumapp.bancodedados.TwittelumBancoDeDados
import br.com.twittelumapp.repository.TweetRepository

object ViewModelFactory : ViewModelProvider.Factory {

    private val application: TwittelumApplication = TwittelumApplication.getInstance()
    private val twittelumBancoDeDados = TwittelumBancoDeDados.getInstance(application)
    private val tweetDao = twittelumBancoDeDados.getTweetDao()
    val tweetRepository = TweetRepository(tweetDao)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return TweetViewModel(tweetRepository) as T
    }

}