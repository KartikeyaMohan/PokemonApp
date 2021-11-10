package com.interview.pokemonapp.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.utils.Resource
import com.interview.pokemonapp.domain.useCase.GetPokemonList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(private val getPokemonList: GetPokemonList): ViewModel() {

    val pokemonList: MutableLiveData<Resource<PokemonResponse>> = MutableLiveData()

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
}