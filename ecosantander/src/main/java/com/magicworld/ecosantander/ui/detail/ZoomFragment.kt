package com.magicworld.ecosantander.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.magicworld.ecosantander.databinding.FragmentZoomBinding
import com.squareup.picasso.Picasso


class ZoomFragment : Fragment() {

    private lateinit var zoomBinding: FragmentZoomBinding
    private val args: ZoomFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        zoomBinding= FragmentZoomBinding.inflate(inflater,container,false)
        return zoomBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lugar = args.lugar
        Picasso.get().load(lugar.urlPicturePoi).into(zoomBinding.zoomImageView)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

}