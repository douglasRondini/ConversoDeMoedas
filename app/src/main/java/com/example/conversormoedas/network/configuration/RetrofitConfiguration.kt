package com.example.conversormoedas.network.configuration

import com.example.conversormoedas.util.Urls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory

object RetrofitConfiguration {
        fun getRetrofitInstance(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(JaxbConverterFactory.create())
                .build()
        }
}