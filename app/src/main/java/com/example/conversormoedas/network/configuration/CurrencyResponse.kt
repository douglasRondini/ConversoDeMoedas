package com.example.conversormoedas.network.configuration

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyResponse(
    @SerializedName("code")
    val code: String,
    @SerializedName("codein")
    val codein: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("high")
    val high: Double,
    @SerializedName("low")
    val low: Double,
    @SerializedName("bid")
    val bid: Double,
    @SerializedName("ask")
    val ask: Double

): Parcelable

