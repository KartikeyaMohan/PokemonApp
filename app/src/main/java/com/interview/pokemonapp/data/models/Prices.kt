package com.interview.pokemonapp.data.models


import com.google.gson.annotations.SerializedName

data class Prices(
    @SerializedName("averageSellPrice")
    val averageSellPrice: Double,
    @SerializedName("avg1")
    val avg1: Double,
    @SerializedName("avg30")
    val avg30: Double,
    @SerializedName("avg7")
    val avg7: Double,
    @SerializedName("germanProLow")
    val germanProLow: Any,
    @SerializedName("lowPrice")
    val lowPrice: Double,
    @SerializedName("lowPriceExPlus")
    val lowPriceExPlus: Double,
    @SerializedName("reverseHoloAvg1")
    val reverseHoloAvg1: Double,
    @SerializedName("reverseHoloAvg30")
    val reverseHoloAvg30: Double,
    @SerializedName("reverseHoloAvg7")
    val reverseHoloAvg7: Double,
    @SerializedName("reverseHoloLow")
    val reverseHoloLow: Double,
    @SerializedName("reverseHoloSell")
    val reverseHoloSell: Any,
    @SerializedName("reverseHoloTrend")
    val reverseHoloTrend: Double,
    @SerializedName("suggestedPrice")
    val suggestedPrice: Any,
    @SerializedName("trendPrice")
    val trendPrice: Double
)