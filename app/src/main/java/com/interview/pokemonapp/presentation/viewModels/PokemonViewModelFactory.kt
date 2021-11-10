package com.interview.pokemonapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.interview.pokemonapp.domain.useCase.GetPokemonList

class PokemonViewModelFactory(private val getPokemonList: GetPokemonList): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(getPokemonList) as T
    }
}