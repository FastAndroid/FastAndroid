package com.linamcaro.fastandroid


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
    val puntuacion: String,
    @SerializedName("sabias")
    val sabias: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("urlPicturePoi")
    val urlPicturePoi: String
): Serializable