package com.linamcaro.fastandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListEcoSantanderActivity : AppCompatActivity() {

    private lateinit var listLugares : ArrayList<lugaresItem>
    private  lateinit var lugaresAdapter: LugaresAdapter
    private  lateinit var ecoSantanderRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_eco_santander)

        ecoSantanderRecyclerView = findViewById(R.id.eco_santander_recycler_view)

        //listLugares = createMockLugares()

        listLugares = loadMocklugaresFromJson()

        lugaresAdapter = LugaresAdapter(listLugares, onItemCliked = {onLugarCliked(it)})

        ecoSantanderRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize((false))
        }
        ecoSantanderRecyclerView.adapter = lugaresAdapter
    }

    private fun onLugarCliked(lugar: lugaresItem) {
        val intent= Intent(this, DetalleActivity::class.java)
        intent.putExtra("lugar",lugar)
        startActivity(intent)

    }

    private fun loadMocklugaresFromJson(): ArrayList<lugaresItem> {
        val lugaresString: String = applicationContext.assets.open("lugares.json").bufferedReader().use {it.readText()}
        val gson = Gson()
        val data = gson.fromJson(lugaresString, lugares::class.java)
        return data
    }
/*
    private fun createMockLugares() : ArrayList<lugares>{
        return arrayListOf(
            lugares(name = "Santurban",
               descripction = "El Páramo Santurbán es un macizo montañoso, conocido geográficamente también como \"Nudo de Santurbán\", es considerado monumento nacional desde 1975",
               puntuacion =  "5.0"
            ),
            lugares(name = "Barichara",
                descripction = "Barichara es un municipio colombiano ubicado en el departamento de Santander. Forma parte de la provincia de Guanentá",
                puntuacion = "4.5"
            ),
            lugares(
                name = "Cerro el santisimo",
                descripction = "El Ecoparque Cerro del Santísimo es un sitio turístico ubicado en la Vereda Helechales, conocido por poseer una escultura de Jesús de Nazaret de 35 m de alto",
                puntuacion = "4"
            ),
            lugares(name = "Quebrada de las Gachas",
                descripction = "Es denominada la quebrada con jacuzzis naturales se encuentra en el municipio de Guadalupe, departamento de Santander, Colombia.",
                puntuacion = "3.5"
            ),
            lugares(name = "Balneario Pozo Azul",
                descripction = "La Poza Azul es un balneario abierto al público fundada desde antes de los años 80′, es un nacimiento de agua cristalina donde los barrioporteños van a distraerse en familia",
                puntuacion =  "4,3"
            )
        )
    }*/
}