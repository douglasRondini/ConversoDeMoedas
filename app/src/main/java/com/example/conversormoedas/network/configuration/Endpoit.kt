package com.example.conversormoedas.network.configuration

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {


    @GET("available/uniq")
      fun getCurrencies(): Call<JsonObject>

    @GET("/last/{from}-{to}")
    fun getCurrencyRate(
        @Path("from") from: String,
        @Path("to") to: String
    ): Call<JsonObject>
}
