package com.interview.pokemonapp.domain.useCase

import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.utils.Resource
import com.interview.pokemonapp.domain.repository.PokemonRepository

class GetPokemonList(private val pokemonRepository: PokemonRepository) {

    suspend fun execute(pageSize: Int, searchQuery: String?, orderBy: String?): Resource<PokemonResponse> {
        return pokemonRepository.getPokemonList(pageSize, searchQuery, orderBy)
    }
}