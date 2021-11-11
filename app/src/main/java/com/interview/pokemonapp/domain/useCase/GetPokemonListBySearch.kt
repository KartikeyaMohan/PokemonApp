package com.interview.pokemonapp.domain.useCase

import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.utils.Resource
import com.interview.pokemonapp.domain.repository.PokemonRepository

class GetPokemonListBySearch(private val pokemonRepository: PokemonRepository) {

    suspend fun execute(pageSize: Int, searchQuery: String): Resource<PokemonResponse> {
        return pokemonRepository.getPokemonListBySearch(pageSize, searchQuery)
    }
}