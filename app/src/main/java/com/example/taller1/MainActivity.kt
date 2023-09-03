package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.taller1.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.example.taller1.modelo.Saludos
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {


    private lateinit var spinner: Spinner
    private lateinit var dataAdapter: ArrayAdapter<String>
    private lateinit var binding: ActivityMainBinding
    private lateinit var saludosList: List<Saludos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saludosList = loadSaludosAct()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            spinner = Spinner(this, R.id.spinner);

            if (saludosList != null && saludosList.count() > 0) {
                Log.d("saludosListState", "saludosList has ${saludosList.count()} items.")
            } else {
                Log.d("saludosList", "saludosList has no items.")
            }

        val namesList = saludosList.map { it.name }
            val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, namesList)

            if (adapter != null && adapter.count > 0) {
                Log.d("adapter", "adapter has ${adapter.count} items.")
            } else {
                Log.d("adapter", "adapter has no items.")
            }

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        Log.d("AdapterSetup", "Before setting adapter")
        val adapterCustom = adapterCustom(this,namesList)
        if (adapterCustom != null && adapterCustom.count > 0) {
        Log.d("adapterCostum", "adapter has ${adapterCustom.count} items.")
    } else {
        Log.d("adapterCustom", "adapter has no items.")
    }
        Log.d("adapterCostum", "adapterCostum has no items.")
        spinner.adapter = adapter
        Log.d("AdapterSetup", "After setting adapter, ")

            if (spinner.adapter != null && spinner.adapter.count > 0) {
                Log.d("SpinnerState", "Spinner has ${spinner.adapter.count} items.")
            } else {
                Log.d("SpinnerState", "Spinner has no items.")
            }
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedSaludo = saludosList[position]
                    val greeting = selectedSaludo.greetigs
                    Toast.makeText(applicationContext, greeting, Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Do nothing
                }
            }

        adapterCustom.notifyDataSetChanged()

        try {
            binding.lenguajes.setOnClickListener {

                startActivity(Intent(baseContext, listaSaludos::class.java))
            }
        } catch (e: Exception) {

            e.printStackTrace()

        }

        binding.ticTacToe.setOnClickListener {

            startActivity(Intent(baseContext, TicTacToe::class.java))
        }
    }

    private fun loadSaludosAct(): List<Saludos> {

        var saludos = mutableListOf<Saludos>()
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



        return saludos

    }

}





