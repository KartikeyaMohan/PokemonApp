package com.interview.pokemonapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.interview.pokemonapp.MainActivity
import com.interview.pokemonapp.R
import com.interview.pokemonapp.data.utils.Resource
import com.interview.pokemonapp.databinding.FragmentPokemonListBinding
import com.interview.pokemonapp.presentation.viewModels.PokemonViewModel

class PokemonListFragment : Fragment() {

    private val TAG = PokemonListFragment::class.java.simpleName
    private lateinit var binding: FragmentPokemonListBinding
    private lateinit var viewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_pokemon_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        viewModel.getPokemonList(20)
        viewModel.pokemonList.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Success -> {
                    Log.i(TAG, it.data.toString())
                }
                is Resource.Loading -> {
                }
                is Resource.Error -> {
                }
            }
        })
    }
}