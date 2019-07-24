package br.com.twittelumapp.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import br.com.twittelumapp.R
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val tweets = listOf("Primeiro tweet", "Segundo tweet")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tweets)
        lista_tweets.adapter = adapter

    }

}