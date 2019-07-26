package br.com.twittelumapp.modelo

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Tweet(val mensagem: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

