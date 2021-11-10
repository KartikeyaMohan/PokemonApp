package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Resistance(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
)