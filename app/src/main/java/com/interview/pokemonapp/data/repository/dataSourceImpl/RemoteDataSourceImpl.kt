package com.interview.pokemonapp.data.repository.dataSourceImpl

import com.interview.pokemonapp.data.api.PokemonApiService
import com.interview.pokemonapp.data.models.PokemonResponse
import com.interview.pokemonapp.data.repository.dataSource.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(private val pokemonApiService: PokemonApiService): RemoteDataSource {

    override suspend fun getPokemonList(pageSize: Int): Response<PokemonResponse> {
        return pokemonApiService.getPokemonList(pageSize)
    }
}