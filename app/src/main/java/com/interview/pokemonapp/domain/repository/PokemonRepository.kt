package com.interview.pokemonapp.domain.repository

import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.utils.Resource

interface PokemonRepository {

    suspend fun getPokemonList(pageSize: Int): Resource<PokemonResponse>
}