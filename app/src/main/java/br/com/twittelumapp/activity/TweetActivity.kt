package br.com.twittelumapp.activity

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import br.com.twittelumapp.R
import br.com.twittelumapp.bancodedados.TweetDao
import br.com.twittelumapp.bancodedados.TwittelumBancoDeDados
import br.com.twittelumapp.modelo.Tweet
import br.com.twittelumapp.repository.TweetRepository
import br.com.twittelumapp.viewmodel.TweetViewModel
import br.com.twittelumapp.viewmodel.ViewModelFactory

class TweetActivity : AppCompatActivity() {
    private val tweetViewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory)
            .get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweet)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun publicaTweet() {
        val campoDeMensagemDoTweet = findViewById<EditText>(R.id.campo_tweet)

        val mensagemDoTweet: String = campoDeMensagemDoTweet.text.toString()

        val tweet = Tweet(mensagemDoTweet)
        Log.i("tweet", tweet.toString())

        tweetViewModel.insere(tweet)

        Toast.makeText(this, "$tweet", Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tweet, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_tweet_salvar -> {
                Log.i("botao", "Botão clicado!")
                publicaTweet()
                finish()
            }
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
