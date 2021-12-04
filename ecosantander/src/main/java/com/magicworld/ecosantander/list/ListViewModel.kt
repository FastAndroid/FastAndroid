package com.magicworld.ecosantander.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.magicworld.ecosantander.model.lugares
import com.magicworld.ecosantander.model.lugaresItem
import java.io.InputStream

class ListViewModel: ViewModel() {

    private val lugaresLoad: MutableLiveData<ArrayList<lugaresItem>> = MutableLiveData()
    val onLugaresLoaded: LiveData<ArrayList<lugaresItem>> =lugaresLoad

    fun loadMocklugaresFromJson(lugaresString: InputStream?){
        val lugareString: String = lugaresString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        lugaresLoad.value= gson.fromJson(lugareString, lugares::class.java)
    }
}