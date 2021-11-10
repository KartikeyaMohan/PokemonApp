package com.interview.pokemonapp.presentation.di

import com.interview.pokemonapp.data.api.PokemonApiService
import com.interview.pokemonapp.data.repository.dataSource.RemoteDataSource
import com.interview.pokemonapp.data.repository.dataSourceImpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun providesRemoteDataSource(pokemonApiService: PokemonApiService): RemoteDataSource {
        return RemoteDataSourceImpl(pokemonApiService)
    }
}