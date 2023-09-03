package com.example.taller1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewmodel.CreationExtras

import com.example.taller1.databinding.ActivityTicTacToeBinding

class TicTacToe : AppCompatActivity() {

    var contador = 0
    var flagAi = false
    var flagA2 = false
    var flagA3 = false
    var flagB1 = false
    var flagB2 = false
    var flagB3 = false
    var flagC1 = false
    var flagC2 = false
    var flagC3 = false
    private val EMPTY = 0
    private val CROSS = 1
    private val CIRCLE = 2
    private lateinit var binding: ActivityTicTacToeBinding
    private var gameBoard = Array(3){Array(3){EMPTY} }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityTicTacToeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.A1.setOnClickListener {
            if (!flagAi) {
                contador++
                flagAi = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.A1.setImageResource(newImageResource);

                if(contador % 2 == 0) gameBoard[0][0] = CROSS else gameBoard[0][0] = CIRCLE
                showWinConditions()
            }

        }


        binding.A2.setOnClickListener {

            if (!flagA2) {
                contador++
                flagA2 = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.A2.setImageResource(newImageResource)
                if(contador % 2 == 0) gameBoard[1][0] = CROSS else gameBoard[1][0] = CIRCLE
                showWinConditions()

            }
        }
        binding.A3.setOnClickListener {
            if (!flagA3) {

                contador++
                flagA3 = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.A3.setImageResource(newImageResource)
                if(contador % 2 == 0) gameBoard[2][0] = CROSS else gameBoard[2][0] = CIRCLE
                showWinConditions()
            }
        }
        binding.B1.setOnClickListener {

            if (!flagB1) {
                contador++
                flagB1 = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.B1.setImageResource(newImageResource)
                if(contador % 2 == 0) gameBoard[0][1] = CROSS else gameBoard[0][1] = CIRCLE
                showWinConditions()
            }
        }
        binding.B2.setOnClickListener {
            if (!flagB2) {
                contador++
                flagB2 = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.B2.setImageResource(newImageResource)
                if(contador % 2 == 0) gameBoard[1][1] = CROSS else gameBoard[1][1] = CIRCLE
                showWinConditions()
            }
        }
        binding.B3.setOnClickListener {
            if (!flagB3) {
                contador++
                flagB3 = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.B3.setImageResource(newImageResource)
                if(contador % 2 == 0) gameBoard[2][1] = CROSS else gameBoard[2][1] = CIRCLE
                showWinConditions()

            }
        }
        binding.C1.setOnClickListener {
            if (!flagC1) {
                contador++
                flagC1 = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.C1.setImageResource(newImageResource)
                if(contador % 2 == 0) gameBoard[0][2] = CROSS else gameBoard[0][2] = CIRCLE
                showWinConditions()
            }
        }
        binding.C2.setOnClickListener {
            if (!flagC2) {
                contador++
                flagC2 = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.C2.setImageResource(newImageResource)
                if(contador % 2 == 0) gameBoard[1][2] = CROSS else gameBoard[1][2] = CIRCLE
                showWinConditions()
            }
        }
        binding.C3.setOnClickListener {
            if (!flagC3) {
                contador++
                flagC3 = true
                val newImageResource =
                    if (contador % 2 == 0) R.drawable.cross else R.drawable.circle
                binding.C3.setImageResource(newImageResource)
                if(contador % 2 == 0) gameBoard[2][2] = CROSS else gameBoard[2][2] = CIRCLE
                showWinConditions()
            }
        }


    }


    private fun showWinConditions() {
        val winningPlayer = if (contador % 2 == 0) CROSS else CIRCLE

        // Check rows
        for (row in gameBoard) {
            if (row.all { it == winningPlayer }) {
                showWinMessage()
                return
            }
        }

        // Check columns
        for (colIndex in 0 until 3) {
            if (gameBoard.all { it[colIndex] == winningPlayer }) {
                showWinMessage()
                return
            }
        }

        // Check diagonals
        if (gameBoard[0][0] == winningPlayer && gameBoard[1][1] == winningPlayer && gameBoard[2][2] == winningPlayer) {
            showWinMessage()
            return
        }

        if (gameBoard[0][2] == winningPlayer && gameBoard[1][1] == winningPlayer && gameBoard[2][0] == winningPlayer) {
            showWinMessage()
            return
        }

        if(flagAi && flagA2 && flagA3 && flagB1 && flagB2 && flagB3 && flagC1 && flagC2 && flagC3){

            val intent = Intent(this,CambiarJugador::class.java)
            startActivity(intent)
        }
    }


    private fun showWinMessage() {
        val winnerSymbol = if (contador % 2 == 0) "Cross" else "Circle"
        val message = "Player $winnerSymbol wins!"
        val intent = Intent(this,CambiarJugador::class.java)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}

