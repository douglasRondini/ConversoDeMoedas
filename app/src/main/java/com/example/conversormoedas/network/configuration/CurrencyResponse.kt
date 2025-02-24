package com.example.conversormoedas.network.configuration

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyResponse(
    @SerializedName("USD")
    val usd: String,

    @SerializedName("AED")
    val aed: String,

    @SerializedName("AFN")
    val afn: String,

    @SerializedName("ALL")
    val all: String,

    @SerializedName("AMD")
    val amd: String,

    @SerializedName("ANG")
    val ang: String,

    @SerializedName("AOA")
    val aoa: String,

    @SerializedName("ARS")
    val ars: String,

    @SerializedName("AUD")
    val aud: String,

    @SerializedName("AZN")
    val azn: String,

    @SerializedName("BAM")
    val bam: String,

    @SerializedName("BBD")
    val bbd: String,

    @SerializedName("BDT")
    val bdt: String,

    @SerializedName("BGN")
    val bgn: String,

    @SerializedName("BHD")
    val bhd: String,

    @SerializedName("BIF")
    val bif: String,

    @SerializedName("BND")
    val bnd: String,

    @SerializedName("BOB")
    val bob: String,

    @SerializedName("BRL")
    val brl: String,

    @SerializedName("BRLT")
    val brlt: String,

    @SerializedName("BSD")
    val bsd: String,

    @SerializedName("BTC")
    val btc: String,

    @SerializedName("BWP")
    val bwp: String,

    @SerializedName("BYN")
    val byn: String,

    @SerializedName("BZD")
    val bzd: String,

    @SerializedName("CAD")
    val cad: String,

    @SerializedName("CHF")
    val chf: String,

    @SerializedName("CHFRTS")
    val chfrts: String,

    @SerializedName("CLP")
    val clp: String,

    @SerializedName("CNH")
    val cnh: String,

    @SerializedName("CNY")
    val cny: String,

    @SerializedName("COP")
    val cop: String,

    @SerializedName("CRC")
    val crc: String,

    @SerializedName("CUP")
    val cup: String,

    @SerializedName("CVE")
    val cve: String,

    @SerializedName("CZK")
    val czk: String,

    @SerializedName("DJF")
    val djf: String,

    @SerializedName("DKK")
    val dkk: String,

    @SerializedName("DOGE")
    val doge: String,

    @SerializedName("DOP")
    val dop: String,

    @SerializedName("DZD")
    val dzd: String,

    @SerializedName("EGP")
    val egp: String,

    @SerializedName("ETB")
    val etb: String,

    @SerializedName("ETH")
    val eth: String,

    @SerializedName("EUR")
    val eur: String,

    @SerializedName("FJD")
    val fjd: String,

    @SerializedName("GBP")
    val gbp: String,

    @SerializedName("GEL")
    val gel: String,

    @SerializedName("GHS")
    val ghs: String,

    @SerializedName("GMD")
    val gmd: String,

    @SerializedName("GNF")
    val gnf: String,

    @SerializedName("GTQ")
    val gtq: String,

    @SerializedName("HKD")
    val hkd: String,

    @SerializedName("HNL")
    val hnl: String,

    @SerializedName("HRK")
    val hrk: String,

    @SerializedName("HTG")
    val htg: String,

    @SerializedName("HUF")
    val huf: String,

    @SerializedName("IDR")
    val idr: String,

    @SerializedName("ILS")
    val ils: String,

    @SerializedName("INR")
    val inr: String,

    @SerializedName("IQD")
    val iqd: String,

    @SerializedName("IRR")
    val irr: String,

    @SerializedName("ISK")
    val isk: String,

    @SerializedName("JMD")
    val jmd: String,

    @SerializedName("JOD")
    val jod: String,

    @SerializedName("JPY")
    val jpy: String,

    @SerializedName("JPYRTS")
    val jpyrts: String,

    @SerializedName("KES")
    val kes: String,

    @SerializedName("KGS")
    val kgs: String,

    @SerializedName("KHR")
    val khr: String,

    @SerializedName("KMF")
    val kmf: String,

    @SerializedName("KRW")
    val krw: String,

    @SerializedName("KWD")
    val kwd: String,

    @SerializedName("KYD")
    val kyd: String,

    @SerializedName("KZT")
    val kzt: String,

    @SerializedName("LAK")
    val lak: String,

    @SerializedName("LBP")
    val lbp: String,

    @SerializedName("LKR")
    val lkr: String,

    @SerializedName("LSL")
    val lsl: String,

    @SerializedName("LTC")
    val ltc: String,

    @SerializedName("LYD")
    val lyd: String,

    @SerializedName("MAD")
    val mad: String,

    @SerializedName("MDL")
    val mdl: String,

    @SerializedName("MGA")
    val mga: String,

    @SerializedName("MKD")
    val mkd: String,

    @SerializedName("MMK")
    val mmk: String,

    @SerializedName("MNT")
    val mnt: String,

    @SerializedName("MOP")
    val mop: String,

    @SerializedName("MRO")
    val mro: String,

    @SerializedName("MUR")
    val mur: String,

    @SerializedName("MVR")
    val mvr: String,

    @SerializedName("MWK")
    val mwk: String,

    @SerializedName("MXN")
    val mxn: String,

    @SerializedName("MYR")
    val myr: String,

    @SerializedName("MZN")
    val mzn: String,

    @SerializedName("NAD")
    val nad: String,

    @SerializedName("NGN")
    val ngn: String,

    @SerializedName("NGNI")
    val ngni: String,

    @SerializedName("NGNPARALLEL")
    val ngnparallel: String,

    @SerializedName("NIO")
    val nio: String,

    @SerializedName("NOK")
    val nok: String,

    @SerializedName("NPR")
    val npr: String,

    @SerializedName("NZD")
    val nzd: String,

    @SerializedName("OMR")
    val omr: String,

    @SerializedName("PAB")
    val pab: String,

    @SerializedName("PEN")
    val pen: String,

    @SerializedName("PGK")
    val pgk: String,

    @SerializedName("PHP")
    val php: String,

    @SerializedName("PKR")
    val pkr: String,

    @SerializedName("PLN")
    val pln: String,

    @SerializedName("PYG")
    val pyg: String,

    @SerializedName("QAR")
    val qar: String,

    @SerializedName("RON")
    val ron: String,

    @SerializedName("RSD")
    val rsd: String,

    @SerializedName("RUB")
    val rub: String,

    @SerializedName("RUBTOD")
    val rubtod: String,

    @SerializedName("RUBTOM")
    val rubtom: String,

    @SerializedName("RWF")
    val rwf: String,

    @SerializedName("SAR")
    val sar: String

): Parcelable

