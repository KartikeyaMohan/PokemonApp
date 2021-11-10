package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Set(
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: ImagesX,
    @SerializedName("legalities")
    val legalities: LegalitiesX,
    @SerializedName("name")
    val name: String,
    @SerializedName("printedTotal")
    val printedTotal: Int,
    @SerializedName("ptcgoCode")
    val ptcgoCode: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("series")
    val series: String,
    @SerializedName("total")
    val total: Int,
    @SerializedName("updatedAt")
    val updatedAt: String
)