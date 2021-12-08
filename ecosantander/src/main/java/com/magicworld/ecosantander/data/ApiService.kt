package com.magicworld.ecosantander.data

import com.magicworld.ecosantander.model.lugares
import retrofit2.http.GET

interface ApiService {
    @GET("FastAndroid/FastAndroid/lugares")
    suspend fun getLugares():lugares
}