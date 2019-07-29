package br.com.twittelumapp.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.com.twittelumapp.R
import br.com.twittelumapp.modelo.Tweet
import br.com.twittelumapp.viewmodel.TweetViewModel
import br.com.twittelumapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {
    private val tweetViewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory)
            .get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        fab_tweet.setOnClickListener {
            val intent = Intent(this, TweetActivity::class.java)
            startActivity(intent)
        }

        tweetViewModel.lista().observe(this, Observer {
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, it)
            lista_tweets.adapter = adapter
        })


        lista_tweets.setOnItemClickListener{
                adapter: AdapterView<*>, item: View, posicao: Int, itemId: Long ->

            val tweet = adapter.getItemAtPosition(posicao) as Tweet

            perguntaSeDeleta(tweet)
        }
    }

    private fun perguntaSeDeleta(tweet: Tweet) {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Deseja mesmo apagar esse tweet?")
        dialogBuilder.setTitle("Atenção")
        dialogBuilder.setPositiveButton("SIM") { _, _ ->
            tweetViewModel.deleta(tweet)
        }
        dialogBuilder.setNegativeButton("NÃO", null)

        dialogBuilder.show()
    }
}