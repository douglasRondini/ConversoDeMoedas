package com.example.conversormoedas

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversormoedas.databinding.ActivityMainBinding
import com.example.conversormoedas.network.configuration.Endpoint
import com.example.conversormoedas.network.configuration.RetrofitConfiguration
import com.example.conversormoedas.network.configuration.CurrencyResponse
import com.example.conversormoedas.network.configuration.ListCurrencyResponse
import com.example.conversormoedas.util.Urls
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getCurrencies()
    }


    fun getCurrencies() {
        val retrofitClient = RetrofitConfiguration.getRetrofitInstance(Urls.URL_CURRECIES)
        val interfaceGet = retrofitClient.create(Endpoint::class.java)

        val callBack = interfaceGet.getCurrencies()

        callBack.enqueue(object : Callback<ListCurrencyResponse>{
            override fun onResponse(
                call: Call<ListCurrencyResponse?>,
                response: Response<ListCurrencyResponse?>
            ) {
                var data = mutableListOf<String>()
                if (response.isSuccessful) {
                    response.body()?.let { listCurrencies ->
                        val currencies = listCurrencies.list?.size.toString()
                        data.add(currencies)
                    }
                }
                val posBRL = data.indexOf("BRL")
                val posUSD = data.indexOf("USD")

                val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, data)
                binding.spnCoin1.adapter = adapter
                binding.spnCoin2.adapter = adapter

                binding.spnCoin1.setSelection(posBRL)
                binding.spnCoin2.setSelection(posUSD)
            }

            override fun onFailure(
                call: Call<ListCurrencyResponse?>,
                t: Throwable
            ) {
                val error = t.message
                println("Erro ao obter moedas: $error")
            }

        })

    }
}