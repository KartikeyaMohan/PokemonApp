package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Tcgplayer(
    @SerializedName("prices")
    val prices: PricesX,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
)