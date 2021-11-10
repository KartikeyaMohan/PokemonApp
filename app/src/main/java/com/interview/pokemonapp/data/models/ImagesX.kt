package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class ImagesX(
    @SerializedName("logo")
    val logo: String,
    @SerializedName("symbol")
    val symbol: String
)