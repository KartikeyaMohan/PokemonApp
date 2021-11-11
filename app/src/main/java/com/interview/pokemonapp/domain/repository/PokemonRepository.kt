package com.interview.pokemonapp.domain.repository

import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.utils.Resource
import retrofit2.Response

interface PokemonRepository {

    suspend fun getPokemonList(pageSize: Int): Resource<PokemonResponse>
    suspend fun getPokemonListBySearch(pageSize: Int, searchQuery: String): Resource<PokemonResponse>
}