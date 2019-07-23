package br.com.twittelumapp

import android.util.Log
import android.view.View

class CliqueDoBotao : View.OnClickListener {
    override fun onClick(v: View?) {
        Log.i("botao","Botão clicado!")
    }
}