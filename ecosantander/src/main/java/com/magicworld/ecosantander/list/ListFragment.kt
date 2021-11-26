package com.magicworld.ecosantander.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.magicworld.ecosantander.databinding.FragmentListBinding
import com.magicworld.ecosantander.main.MainActivity
import com.magicworld.ecosantander.model.lugares
import com.magicworld.ecosantander.model.lugaresItem


class ListFragment : Fragment() {

    private lateinit var listLugares : ArrayList<lugaresItem>
    private lateinit var  listBinding: FragmentListBinding
    private lateinit var lugaresAdapter: LugaresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding=FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        listLugares = loadMocklugaresFromJson()
        lugaresAdapter= LugaresAdapter(listLugares, onItemCliked = {onLugarCliked(it)})

        listBinding.ecoSantanderRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun onLugarCliked(lugar: lugaresItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar=lugar))
    }

    private fun loadMocklugaresFromJson(): ArrayList<lugaresItem> {
        val lugaresString: String = context?.assets?.open("lugares.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(lugaresString, lugares::class.java)
        return data
    }

}