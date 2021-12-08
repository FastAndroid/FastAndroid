package com.magicworld.ecosantander.data

class LugaresRepository {
    suspend fun getlugares() =ApiFactory.retrofit.getLugares()
}