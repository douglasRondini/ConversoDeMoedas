package com.example.conversormoedas.network.configuration

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {
    @GET("/xml/available/uniq")
      fun getCurrencies(): Call<ListCurrencyResponse>

    @GET("/json/last/{from}-{to}")
    fun getCurrencyRate(
        @Path(value = "from", encoded = true) from: String,
        @Path(value = "to", encoded = true) to: String,
        @Query("token") token: String = "?token=5a3c6510928731ac378185b02db1a8c8521291aefb696baf967ad37e3e80c405"
    ): Call<JsonObject>
}
