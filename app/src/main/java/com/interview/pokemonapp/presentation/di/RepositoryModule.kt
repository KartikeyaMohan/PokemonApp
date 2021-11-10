package com.interview.pokemonapp.presentation.di

import com.interview.pokemonapp.data.repository.PokemonRepositoryImpl
import com.interview.pokemonapp.data.repository.dataSource.RemoteDataSource
import com.interview.pokemonapp.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesPokemonRepository(remoteDataSource: RemoteDataSource): PokemonRepository {
        return PokemonRepositoryImpl(remoteDataSource)
    }
}