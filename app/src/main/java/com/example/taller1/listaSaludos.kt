package com.example.taller1

import android.R
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.taller1.databinding.ActivityListaSaludosBinding
import com.example.taller1.databinding.ActivityListaSaludosBinding.inflate
import com.example.taller1.modelo.Saludos
import org.json.JSONObject


class listaSaludos : AppCompatActivity() {
    private lateinit var binding : ActivityListaSaludosBinding
    private lateinit var saludosList: List<Saludos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaSaludosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saludosList = loadSaludos()
        if (saludosList != null && saludosList.count() > 0) {
            Log.d("saludosListListaSaludosState", "saludosList has ${saludosList.count()} items.")
        } else {
            Log.d("saludosList", "saludosList has no items.")
        }
        val namesList = saludosList.map { it.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesList)
        binding.listaIDIOMAS.adapter = adapter

        binding.listaIDIOMAS.setOnItemClickListener { parent, view, position, id ->
            val selectedSaludo = saludosList[position]
            Toast.makeText(
                this@listaSaludos,
                "${selectedSaludo.greetigs}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

          fun loadSaludos(): List<Saludos> {
              var saludos = mutableListOf<Saludos>()
              try {

                      var json_string =
                          this.assets.open("saludos.json").bufferedReader().use { it.readText() }
                      var json = JSONObject(json_string)
                      var saludosJsonArray = json.getJSONArray("saludos")
                      for (i in 0 until saludosJsonArray.length()) {
                          var jsonObject = saludosJsonArray.getJSONObject(i)
                          var name = jsonObject.getString("name")
                          var greeting = jsonObject.getString("greeting")

                          var greet = Saludos(name, greeting)
                          saludos.add(greet)

                      }

              } catch (e: Exception) {
                  e.printStackTrace()
              }
              return saludos

          }
      }

