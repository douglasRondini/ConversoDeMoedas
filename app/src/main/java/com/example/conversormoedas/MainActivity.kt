package com.example.conversormoedas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversormoedas.network.configuration.Endpoint
import com.example.conversormoedas.network.configuration.RetrofitConfiguration
import com.example.conversormoedas.network.configuration.CurrencyResponse
import com.example.conversormoedas.util.Urls
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getCurrencies()
    }


    fun getCurrencies() {
        val retrofitClient = RetrofitConfiguration.getRetrofitInstance(Urls.URL_CURRECIES)
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getCurrencies()
        val data = callback

        callback.enqueue(object : Callback<CurrencyResponse> {
            override fun onResponse(
                call: Call<CurrencyResponse?>,
                response: Response<CurrencyResponse?>
            ) {
               response.body()
            }

            override fun onFailure(
                call: Call<CurrencyResponse?>,
                t: Throwable
            ) {
                val erro = t.message
            }

        })

    }
}