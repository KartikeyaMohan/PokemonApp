package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class LegalitiesX(
    @SerializedName("expanded")
    val expanded: String,
    @SerializedName("unlimited")
    val unlimited: String
)