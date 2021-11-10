package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(
    @SerializedName("abilities")
    val abilities: List<Ability>?,
    @SerializedName("attacks")
    val attacks: List<Attack>?,
    @SerializedName("hp")
    val hp: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("images")
    val images: Images?,
    @SerializedName("level")
    val level: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("resistances")
    val resistances: List<Resistance>?,
    @SerializedName("subtypes")
    val subtypes: List<String>?,
    @SerializedName("types")
    val types: List<String>?,
    @SerializedName("weaknesses")
    val weaknesses: List<Weaknesse>?
): Serializable