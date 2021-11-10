package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("large")
    val large: String,
    @SerializedName("small")
    val small: String
)