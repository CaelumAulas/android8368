package br.com.twittelumapp.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.ArrayAdapter
import br.com.twittelumapp.R
import br.com.twittelumapp.bancodedados.TwittelumBancoDeDados
import br.com.twittelumapp.modelo.Tweet
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val twittelumBancoDeDados = TwittelumBancoDeDados.getInstance(this)
        val tweetDao = twittelumBancoDeDados.getTweetDao()
        val tweets: List<Tweet> = tweetDao.lista()

//        val tweets = listOf("Primeiro tweet", "Segundo tweet")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tweets)
        lista_tweets.adapter = adapter

        fab_tweet.setOnClickListener {
            val intent = Intent(this, TweetActivity::class.java)
            startActivity(intent)
        }
    }

}