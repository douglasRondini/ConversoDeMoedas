package com.example.conversormoedas.network.configuration

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListCurrencyResponse (
    @SerializedName("USDBRL")
    val usdbrl: CurrencyResponse,
    @SerializedName("EURBRL")
    val EURBRL: CurrencyResponse
): Parcelable
