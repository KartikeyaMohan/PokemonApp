package com.interview.pokemonapp.presentation.di

import com.interview.pokemonapp.domain.repository.PokemonRepository
import com.interview.pokemonapp.domain.useCase.GetPokemonList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesGetPokemonList(pokemonRepository: PokemonRepository): GetPokemonList {
        return GetPokemonList(pokemonRepository)
    }
}