package com.linamcaro.fastandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.linamcaro.fastandroid.databinding.ActivityDetalleBinding
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val lugar: lugaresItem = intent.extras?.getSerializable("lugar") as lugaresItem
        with(detalleBinding){
            nombreTextView.text = lugar.name
            description1TextView.text = lugar.descriptionUno
            sabiasTextView.text = lugar.sabias
            climaTextView.text = lugar.clima
            Picasso.get().load(lugar.urlPicturePoi).into(pictureImageView)
        }

    }
}