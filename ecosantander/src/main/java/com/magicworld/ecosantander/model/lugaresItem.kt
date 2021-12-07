package com.magicworld.ecosantander.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class lugaresItem(
    @SerializedName("clima")
    val clima: String,
    @SerializedName("descripction")
    val descripction: String,
    @SerializedName("descriptionUno")
    val descriptionUno: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("puntuacion")
    val puntuacion: Float,
    @SerializedName("sabias")
    val sabias: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("urlPicturePoi")
    val urlPicturePoi: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("zoom")
    val zoom: Float
): Serializable