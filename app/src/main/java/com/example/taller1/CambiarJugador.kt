package com.example.taller1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1.databinding.ActivityTicTacToeBinding

class CambiarJugador : AppCompatActivity() {
    private lateinit var binding: ActivityTicTacToeBinding
    private lateinit var NewBinding: ActivityTicTacToeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTicTacToeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, TicTacToe::class.java)
        startActivity(intent)

    }

}

