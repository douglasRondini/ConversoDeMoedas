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
import com.example.conversormoedas.network.configuration.ListCodeSpinner
import com.example.conversormoedas.network.configuration.ListCurrencyResponse
import com.example.conversormoedas.util.Urls
import com.google.gson.JsonObject
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

//      getCurrencies()
        listCodeSpiner()
    }

    fun listCodeSpiner() {
        val currencyCodes = ListCodeSpinner.list

        val posBRL = currencyCodes.indexOf("BRL")
        val posUSD = currencyCodes.indexOf("USD")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currencyCodes)
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item )
            binding.spnCoin1.adapter = adapter
            binding.spnCoin2.adapter = adapter

        binding.spnCoin1.setSelection(posBRL)
        binding.spnCoin2.setSelection(posUSD)

    }

}