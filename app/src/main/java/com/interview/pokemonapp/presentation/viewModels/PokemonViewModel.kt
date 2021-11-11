package com.interview.pokemonapp.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.utils.Resource
import com.interview.pokemonapp.domain.useCase.GetPokemonList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getPokemonList: GetPokemonList
): ViewModel() {

    val pokemonList: MutableLiveData<Resource<PokemonResponse>> = MutableLiveData()

//    fun getPokemonList(pageSize: Int) = viewModelScope.launch(Dispatchers.IO) {
//        try {
//            pokemonList.postValue(Resource.Loading())
//            val apiResult = getPokemonList.execute(pageSize, null, null)
//            pokemonList.postValue(apiResult)
//        }
//        catch (exception: Exception) {
//            pokemonList.postValue(Resource.Error(exception.message.toString()))
//        }
//    }

//    fun getPokemonListBySearch(pageSize: Int, searchQuery: String) =
//        viewModelScope.launch(Dispatchers.IO) {
//        try {
//            pokemonList.postValue(Resource.Loading())
//            val apiResult = getPokemonList.execute(pageSize, searchQuery, null)
//            pokemonList.postValue(apiResult)
//        }
//        catch (exception: Exception) {
//            pokemonList.postValue(Resource.Error(exception.message.toString()))
//        }
//    }
//
//    fun getPokemonListByOrder(pageSize: Int, orderBy: String) =
//        viewModelScope.launch(Dispatchers.IO) {
//        try {
//            pokemonList.postValue(Resource.Loading())
//            val apiResult = getPokemonList.execute(pageSize, null, orderBy)
//            pokemonList.postValue(apiResult)
//        }
//        catch (exception: Exception) {
//            pokemonList.postValue(Resource.Error(exception.message.toString()))
//        }
//    }
//
    fun getPokemonList(pageSize: Int, searchQuery: String?, orderBy: String?) =
        viewModelScope.launch(Dispatchers.IO) {
        try {
            pokemonList.postValue(Resource.Loading())
            val apiResult = getPokemonList.execute(pageSize, searchQuery, orderBy)
            pokemonList.postValue(apiResult)
        }
        catch (exception: Exception) {
            pokemonList.postValue(Resource.Error(exception.message.toString()))
        }
    }
}