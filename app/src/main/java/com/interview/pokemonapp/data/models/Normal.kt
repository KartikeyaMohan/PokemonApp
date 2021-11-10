package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Normal(
    @SerializedName("directLow")
    val directLow: Double,
    @SerializedName("high")
    val high: Double,
    @SerializedName("low")
    val low: Double,
    @SerializedName("market")
    val market: Double,
    @SerializedName("mid")
    val mid: Double
)