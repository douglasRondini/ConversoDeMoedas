package com.example.conversormoedas

import android.os.Bundle
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.iterator
import com.example.conversormoedas.databinding.ActivityMainBinding
import com.example.conversormoedas.network.configuration.Endpoint
import com.example.conversormoedas.network.configuration.RetrofitConfiguration
import com.example.conversormoedas.network.configuration.CurrencyResponse
import com.example.conversormoedas.network.configuration.ListCodeSpinner
import com.example.conversormoedas.network.configuration.ListCurrencyResponse
import com.example.conversormoedas.util.Urls
import com.google.gson.JsonObject
import okhttp3.internal.format
import okhttp3.internal.toHexString
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import kotlin.math.absoluteValue

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


      currencyResponse()
       buttonConverte()


    }

    fun buttonConverte() {
        binding.button.setOnClickListener {
            val value = binding.edtValor.text.toString()
            if (value.isEmpty()) {
                mensssagem("preencha um valor")
                clear()
                return@setOnClickListener
            }
            convertMoney()

        }
    }
    fun clear() {
        if (binding.edtValor.text.toString().isEmpty()){
            binding.txtResult.text = ""
        }
    }

    fun convertMoney() {
        val from = binding.spnCoin1.selectedItem.toString()
        val to = binding.spnCoin2.selectedItem.toString()

        val retrofitClient = RetrofitConfiguration.getRetrofitInstance(Urls.URL_CURRECIES)
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callBack = endpoint.getCurrencyRate(
            from,
            to
        )

        callBack.enqueue(object : Callback<JsonObject>{
            override fun onResponse(
                p0: Call<JsonObject?>,
                response: Response<JsonObject?>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.entrySet()?.find { it.key == from + to }
                    val rate = data?.value?.asJsonObject?.entrySet()?.find { it.key == "bid" }
                    val valueRate = rate?.value?.asString?.toDoubleOrNull()

                    if (valueRate != null) {
                        val money = binding.edtValor.text.toString().toDouble()
                        val conversion = valueRate * money
                        val format = String.format("%.2f",conversion)
                        binding.txtResult.text = "R$:$format"
                    } else {
                        mensssagem("Erro: valor da taxa de câmbio inválido")
                    }
                } else {
                    mensssagem("Erro: combinação invalida")

                }


            }

            override fun onFailure(
                p0: Call<JsonObject?>,
                p1: Throwable
            ) {
                println(p1.message)
            }

        })



    }
    fun currencyResponse() {
        val retrofitClient = RetrofitConfiguration.getRetrofitInstance(Urls.URL_CURRECIES)
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callBack = endpoint.getCurrencies()

        callBack.enqueue(object : Callback<JsonObject>{
            override fun onResponse(
                p0: Call<JsonObject?>,
                response: Response<JsonObject?>
            ) {
                var data = mutableListOf<String>()
                response.body()?.keySet()?.iterator()?.forEach {
                    data.add(it)
                }
                listCodeSpiner(data)

                }

            override fun onFailure(p0: Call<JsonObject?>, p1: Throwable) {
                println(p1.message)
            }

        })


    }


    fun mensssagem(mensagens: String) {
        Toast.makeText(this, mensagens, Toast.LENGTH_SHORT).show()
    }





    fun listCodeSpiner(data: MutableList<String>) {

        val posBRL = data.indexOf("BRL")
        val posUSD = data.indexOf("USD")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data)
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item )
            binding.spnCoin1.adapter = adapter
            binding.spnCoin2.adapter = adapter

        binding.spnCoin1.setSelection(posUSD)
        binding.spnCoin2.setSelection(posBRL)

    }


}