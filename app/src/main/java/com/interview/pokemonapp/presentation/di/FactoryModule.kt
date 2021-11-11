package com.interview.pokemonapp.presentation.di

import com.interview.pokemonapp.domain.useCase.GetPokemonList
import com.interview.pokemonapp.domain.useCase.GetPokemonListBySearch
import com.interview.pokemonapp.presentation.viewModels.PokemonViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun providesPokemonFactory(
        getPokemonList: GetPokemonList,
        getPokemonListBySearch: GetPokemonListBySearch): PokemonViewModelFactory {
        return PokemonViewModelFactory(getPokemonList, getPokemonListBySearch)
    }
}