package br.com.twittelumapp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import br.com.twittelumapp.TwittelumApplication
import br.com.twittelumapp.bancodedados.TwittelumBancoDeDados
import br.com.twittelumapp.modelo.Tweet
import br.com.twittelumapp.repository.TweetRepository

class TweetViewModel(private val tweetRepository: TweetRepository) : ViewModel() {

    fun insere(tweet: Tweet) = tweetRepository.insere(tweet)

    fun lista(): LiveData<List<Tweet>> = tweetRepository.lista()
}