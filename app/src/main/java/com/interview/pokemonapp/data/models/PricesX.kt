package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class PricesX(
    @SerializedName("holofoil")
    val holofoil: Holofoil,
    @SerializedName("normal")
    val normal: Normal,
    @SerializedName("reverseHolofoil")
    val reverseHolofoil: ReverseHolofoil,
    @SerializedName("1stEditionHolofoil")
    val stEditionHolofoil: StEditionHolofoil
)