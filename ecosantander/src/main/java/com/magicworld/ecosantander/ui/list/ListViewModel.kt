package com.magicworld.ecosantander.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.magicworld.ecosantander.data.LugaresRepository
import com.magicworld.ecosantander.model.lugares
import com.magicworld.ecosantander.model.lugaresItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel: ViewModel() {

    private val lugaresLoad: MutableLiveData<ArrayList<lugaresItem>> = MutableLiveData()
    val onLugaresLoaded: LiveData<ArrayList<lugaresItem>> =lugaresLoad

    private val repository = LugaresRepository()

    fun getLugaresFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            lugaresLoad.postValue(repository.getlugares())
        }
    }

    fun loadMocklugaresFromJson(lugaresString: InputStream?){
        val lugareString: String = lugaresString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        lugaresLoad.value= gson.fromJson(lugareString, lugares::class.java)
    }
}