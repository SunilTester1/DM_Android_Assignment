package com.mishraji.dm_android_assignment.api

import com.mishraji.dm_android_assignment.data.Cake
import retrofit2.http.GET

interface CakeApi {
     companion object {
         const val BASE_URL = "https://run.mocky.io/v3/"
     }

    @GET("0ba63b71-bb15-434e-9da3-98435dcb346d/")
    suspend fun getCake(): List<Cake>
}