package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("name")
    val name: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)