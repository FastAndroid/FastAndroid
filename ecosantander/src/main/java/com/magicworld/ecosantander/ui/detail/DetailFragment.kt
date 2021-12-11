package com.magicworld.ecosantander.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.magicworld.ecosantander.R
import com.magicworld.ecosantander.databinding.FragmentDetailBinding
import com.magicworld.ecosantander.ui.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var  detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private val callback = OnMapReadyCallback { googleMap ->

        val lugar = args.lugar
        val lugares = LatLng(lugar.lat,lugar.lng)
        googleMap.addMarker(
            MarkerOptions()
                .position(lugares)
                .title(lugar.name)
                .snippet(lugar.puntuacion.toString())
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugares,lugar.zoom))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater,container,false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lugar = args.lugar

        with(detailBinding){
            nombreTextView.text = lugar.name
            description1TextView.text = lugar.descriptionUno
            sabiasTextView.text = lugar.sabias
            climaTextView.text = lugar.clima
            Picasso.get().load(lugar.urlPicturePoi).into(pictureImageView)

            imageButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(lugares=lugar))
            }
            pictureImageView.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToZoomFragment(lugar=lugar))
            }
        }
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

}