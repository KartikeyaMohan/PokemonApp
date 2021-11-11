package com.interview.pokemonapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.interview.pokemonapp.domain.useCase.GetPokemonList
import com.interview.pokemonapp.domain.useCase.GetPokemonListBySearch

class PokemonViewModelFactory(
    private val getPokemonList: GetPokemonList,
    private val getPokemonListBySearch: GetPokemonListBySearch
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(getPokemonList, getPokemonListBySearch) as T
    }
}