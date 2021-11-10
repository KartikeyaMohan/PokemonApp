package com.interview.pokemonapp.data.repository.dataSource

import com.interview.pokemonapp.data.models.PokemonResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getPokemonList(pageSize: Int): Response<PokemonResponse>
}