package com.magicworld.ecosantander.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.magicworld.ecosantander.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var  detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

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
        }
    }

}