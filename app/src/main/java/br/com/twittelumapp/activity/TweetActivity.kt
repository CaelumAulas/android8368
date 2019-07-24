package br.com.twittelumapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.twittelumapp.R

class TweetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweet)

        val botao = findViewById<Button>(R.id.publica_button)

        botao.setOnClickListener {
            Log.i("botao","Botão clicado!")
            publicaTweet()
            finish()
        }
    }

    private fun publicaTweet() {
        val campoDeMensagemDoTweet = findViewById<EditText>(R.id.campo_tweet)

        val mensagemDoTweet : String = campoDeMensagemDoTweet.text.toString()

        Toast.makeText(this, mensagemDoTweet, Toast.LENGTH_LONG).show()
    }
}
