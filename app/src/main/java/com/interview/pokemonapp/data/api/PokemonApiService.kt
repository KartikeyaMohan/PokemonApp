package com.interview.pokemonapp.data.api

import com.interview.pokemonapp.data.models.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {

    @GET("v2/cards")
    suspend fun getPokemonList(
        @Query("pageSize") pageSize: Int
    ): Response<PokemonResponse>
}