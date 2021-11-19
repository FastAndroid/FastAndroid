package com.linamcaro.fastandroid


import com.google.gson.annotations.SerializedName

data class lugaresItem(
    @SerializedName("descripction")
    val descripction: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)