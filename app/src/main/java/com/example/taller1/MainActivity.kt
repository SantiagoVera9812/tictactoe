package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.taller1.databinding.ActivityMainBinding
import com.example.taller1.modelo.Paises
import com.example.taller1.modelo.Saludos
import com.example.taller1.modelo.Hello
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var paisList: List<Paises>
    private lateinit var helloList: List<Hello>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paisList = loadPaisesAct()
        helloList = loadHelloAct()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            var spinner : Spinner = findViewById(R.id.spinner)

        val namesList = paisList.map { it.nombre_pais}
        val idiomas = helloList.map{it.language}
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, namesList)

        spinner.adapter = adapter


            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedSaludo = paisList[position]
                    val languagePais = selectedSaludo.language
                    for(i in idiomas.indices){
                        if(idiomas[i] == languagePais){

                            val hellomsg = helloList[i].hello
                            Toast.makeText(this@MainActivity, hellomsg,Toast.LENGTH_SHORT).show()
                            break
                        }

                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Do nothing
                }
            }



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

     fun loadSaludosAct(): List<Saludos> {

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

    fun loadPaisesAct(): List<Paises>{

        var saludos = mutableListOf<Paises>()

        var json_string = this.assets.open("paises.json").bufferedReader().use{it.readText()}

        var json = JSONObject(json_string)
        var paises = json.getJSONArray("paises")
        for(i in 0 until paises.length()){

            var jsonObject = paises.getJSONObject(i)
            var capital = jsonObject.getString("capital")
            var nombre_pais = jsonObject.getString("nombre_pais")
            var nombre_pais_int = jsonObject.getString("nombre_pais_int")
            var siglas = jsonObject.getString("sigla")
            var language = jsonObject.getString("language")
            var pais = Paises(capital,nombre_pais,nombre_pais_int,siglas,language)

            saludos.add(pais)
        }

        return saludos
    }

    fun loadHelloAct(): List<Hello> {

        val saludos = mutableListOf<Hello>()
        var json_string = this.assets.open("hello.json").bufferedReader().use{it.readText()}

        var json = JSONObject(json_string)
        var hellos = json.getJSONArray("hello")
        for(i in 0 until hellos.length()) {

            var jsonObject = hellos.getJSONObject(i)
            var language = jsonObject.getString("language")
            var hello = jsonObject.getString("hello")

            var hi = Hello(language, hello)

            saludos.add(hi)

        }
        return saludos

    }

}





