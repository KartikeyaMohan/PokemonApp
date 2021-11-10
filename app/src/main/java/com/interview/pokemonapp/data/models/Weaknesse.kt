package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Weaknesse(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
): Serializable