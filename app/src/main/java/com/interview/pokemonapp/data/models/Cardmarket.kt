package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Cardmarket(
    @SerializedName("prices")
    val prices: Prices,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
)