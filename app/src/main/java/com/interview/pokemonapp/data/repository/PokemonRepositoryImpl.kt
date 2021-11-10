package com.interview.pokemonapp.data.repository

import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.repository.dataSource.RemoteDataSource
import com.interview.pokemonapp.data.utils.Resource
import com.interview.pokemonapp.domain.repository.PokemonRepository
import retrofit2.Response

class PokemonRepositoryImpl(private val remoteDataSource: RemoteDataSource): PokemonRepository {

    override suspend fun getPokemonList(pageSize: Int): Resource<PokemonResponse> {
        return responseToResource(remoteDataSource.getPokemonList(pageSize))
    }

    private fun responseToResource(response: Response<PokemonResponse>): Resource<PokemonResponse> {
        if(response.isSuccessful) {
            response.body()?.let {
                    result -> return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}