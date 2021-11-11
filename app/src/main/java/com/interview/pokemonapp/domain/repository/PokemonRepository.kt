package com.interview.pokemonapp.domain.repository

import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.utils.Resource
import retrofit2.Response

interface PokemonRepository {
    suspend fun getPokemonList(pageSize: Int, searchQuery: String?, orderBy: String?): Resource<PokemonResponse>
}