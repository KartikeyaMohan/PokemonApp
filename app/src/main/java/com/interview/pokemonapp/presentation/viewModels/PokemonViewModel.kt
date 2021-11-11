package com.interview.pokemonapp.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.utils.Resource
import com.interview.pokemonapp.domain.useCase.GetPokemonList
import com.interview.pokemonapp.domain.useCase.GetPokemonListBySearch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getPokemonList: GetPokemonList,
    private val getPokemonListBySearch: GetPokemonListBySearch
): ViewModel() {

    val pokemonList: MutableLiveData<Resource<PokemonResponse>> = MutableLiveData()
    val searchedPokemon: MutableLiveData<Resource<PokemonResponse>> = MutableLiveData()

    fun getPokemonList(pageSize: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            pokemonList.postValue(Resource.Loading())
            val apiResult = getPokemonList.execute(pageSize)
            pokemonList.postValue(apiResult)
        }
        catch (exception: Exception) {
            pokemonList.postValue(Resource.Error(exception.message.toString()))
        }
    }

    fun getPokemonListBySearch(pageSize: Int, searchQuery: String) =
        viewModelScope.launch(Dispatchers.IO) {
        try {
            searchedPokemon.postValue(Resource.Loading())
            val apiResult = getPokemonListBySearch.execute(pageSize, searchQuery)
            searchedPokemon.postValue(apiResult)
        }
        catch (exception: Exception) {
            searchedPokemon.postValue(Resource.Error(exception.message.toString()))
        }
    }
}