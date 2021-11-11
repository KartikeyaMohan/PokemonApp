package com.interview.pokemonapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.interview.pokemonapp.MainActivity
import com.interview.pokemonapp.R
import com.interview.pokemonapp.data.models.Data
import com.interview.pokemonapp.data.utils.Resource
import com.interview.pokemonapp.databinding.FragmentPokemonListBinding
import com.interview.pokemonapp.presentation.adapters.PokemonAdapter
import com.interview.pokemonapp.presentation.listeners.OnItemClickListener
import com.interview.pokemonapp.presentation.viewModels.PokemonViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokemonListFragment : Fragment() {

    private val TAG = PokemonListFragment::class.java.simpleName
    private lateinit var binding: FragmentPokemonListBinding
    private lateinit var viewModel: PokemonViewModel
    private lateinit var onItemClickListener: OnItemClickListener
    private lateinit var pokemonAdapter: PokemonAdapter
    private var pokemonList: MutableList<Data> = mutableListOf()
    private lateinit var searchQuery: String

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
        onItemClickListener = object : OnItemClickListener {
            override fun onItemClicked(position: Int) {
                val bundle = Bundle().apply {
                    putSerializable("selected_pokemon", pokemonList[position])
                }
                findNavController().navigate(
                    R.id.action_pokemonListFragment_to_pokemonDetailsFragment,
                    bundle
                )
            }
        }
        pokemonAdapter = PokemonAdapter(onItemClickListener)
        initRecyclerView()
        initSearchView()
        getPokemonList()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            adapter = pokemonAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun initSearchView() {
        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    searchQuery = "name:".plus(p0.toString()).plus("*")
                    getPokemonListBySearch()
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    MainScope().launch {
                        delay(1000)
                        searchQuery = "name:".plus(p0.toString()).plus("*")
                        getPokemonListBySearch()
                    }
                    return false
                }
            }
        )

        binding.searchView.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                initRecyclerView()
                getPokemonList()
                return false
            }
        })
    }

    private fun getPokemonListBySearch() {
        viewModel.getPokemonListBySearch(20, searchQuery)
        viewModel.searchedPokemon.observe(viewLifecycleOwner, { response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let {
                        pokemonList.addAll(it.data)
                        pokemonAdapter.differ.submitList(it.data)
                    }
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                }
                is Resource.Loading -> {
                    binding.recyclerView.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    Toast.makeText(context, context?.resources?.getString(R.string.default_error_message), Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun getPokemonList() {
        viewModel.getPokemonList(20)
        viewModel.pokemonList.observe(viewLifecycleOwner, { response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let {
                        pokemonList.addAll(it.data)
                        pokemonAdapter.differ.submitList(it.data)
                    }
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                }
                is Resource.Loading -> {
                    binding.recyclerView.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    Toast.makeText(context, context?.resources?.getString(R.string.default_error_message), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}