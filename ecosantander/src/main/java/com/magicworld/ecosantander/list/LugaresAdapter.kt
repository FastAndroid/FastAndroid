package com.magicworld.ecosantander.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.magicworld.ecosantander.R
import com.magicworld.ecosantander.model.lugaresItem
import com.squareup.picasso.Picasso

class LugaresAdapter(
    private val lugaresList: ArrayList<lugaresItem>,
    private val onItemCliked: (lugaresItem) -> Unit
) :
    RecyclerView.Adapter<LugaresAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_lugar, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugar = lugaresList[position]
        holder.itemView.setOnClickListener{onItemCliked(lugaresList[position])}
        holder.bind(lugar)
    }

    override fun getItemCount(): Int {
        return lugaresList.size
    }

    fun appendItems(newItem: ArrayList<lugaresItem>) {
        this.lugaresList.clear()
        this.lugaresList.addAll(newItem)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView: TextView = itemView.findViewById((R.id.description_text_view))
        private var notaRatingBar: RatingBar = itemView.findViewById(R.id.nota_rating_bar)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(lugar: lugaresItem){
            nameTextView.text =lugar.name
            descriptionTextView.text = lugar.descripction
            notaRatingBar.rating= lugar.puntuacion
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)
        }
    }
}