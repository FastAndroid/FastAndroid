package com.magicworld.ecosantander.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.magicworld.ecosantander.databinding.FragmentListBinding
import com.magicworld.ecosantander.ui.main.MainActivity
import com.magicworld.ecosantander.model.lugaresItem


class ListFragment : Fragment() {

    private var listLugares : ArrayList<lugaresItem> = arrayListOf()
    private lateinit var  listBinding: FragmentListBinding
    private val listViewModel: ListViewModel by viewModels()
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

        listViewModel.loadMocklugaresFromJson(context?.assets?.open("lugares.json"))
        //listViewModel.getLugaresFromServer()
        lugaresAdapter= LugaresAdapter(listLugares, onItemCliked = {onLugarCliked(it)})

        listBinding.ecoSantanderRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
        listViewModel.onLugaresLoaded.observe(viewLifecycleOwner,{result->
            onLugaresLoadedSubcribe(result)
        })
    }

    private fun onLugaresLoadedSubcribe(result: ArrayList<lugaresItem>?) {
        result?.let { listLugares->
            lugaresAdapter.appendItems(listLugares)
        }
    }

    private fun onLugarCliked(lugar: lugaresItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar=lugar))
    }



}