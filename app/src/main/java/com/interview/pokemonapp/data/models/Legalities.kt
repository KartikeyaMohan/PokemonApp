package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Legalities(
    @SerializedName("expanded")
    val expanded: String,
    @SerializedName("unlimited")
    val unlimited: String
)