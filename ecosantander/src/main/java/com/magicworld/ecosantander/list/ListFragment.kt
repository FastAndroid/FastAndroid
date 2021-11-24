package com.magicworld.ecosantander.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.magicworld.ecosantander.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var  listBinding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding=FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

}