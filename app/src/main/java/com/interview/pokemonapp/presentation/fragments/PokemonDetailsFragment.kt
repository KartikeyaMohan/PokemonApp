package com.interview.pokemonapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.interview.pokemonapp.R
import com.interview.pokemonapp.data.models.*
import com.interview.pokemonapp.databinding.FragmentPokemonDetailsBinding
import com.interview.pokemonapp.presentation.adapters.TagAdapter

class PokemonDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPokemonDetailsBinding
    private lateinit var pokemon: Data
    private val typesAdapter = TagAdapter()
    private val abilitiesAdapter = TagAdapter()
    private val attackAdapter = TagAdapter()
    private val subTypeAdapter = TagAdapter()
    private val resistancesAdapter = TagAdapter()
    private val weaknessesAdapter = TagAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_pokemon_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: PokemonDetailsFragmentArgs by navArgs()
        pokemon = args.selectedPokemon
        render()
        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun render() {
        binding.title.text = pokemon.name
        binding.levelValue.text = pokemon.level
        binding.hpValue.text = pokemon.hp
        Glide.with(binding.mainImage.context).load(pokemon.images?.large).into(binding.mainImage)
        binding.typesRecycler.apply {
            adapter = typesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        typesAdapter.differ.submitList(pokemon.types)
        binding.abilitiesRecycler.apply {
            adapter = abilitiesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        abilitiesAdapter.differ.submitList(abilitiesListToStringList(pokemon.abilities))
        binding.attacksRecycler.apply {
            adapter = attackAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        attackAdapter.differ.submitList(attacksListToStringList(pokemon.attacks))
        binding.subTypesRecycler.apply {
            adapter = subTypeAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        subTypeAdapter.differ.submitList(pokemon.subtypes)
        binding.resistancesRecycler.apply {
            adapter = resistancesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        resistancesAdapter.differ.submitList(resistancesListToStringList(pokemon.resistances))
        binding.weaknessesRecycler.apply {
            adapter = weaknessesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        weaknessesAdapter.differ.submitList(weaknessesListToStringList(pokemon.weaknesses))
    }

    private fun abilitiesListToStringList(abilityList: List<Ability>?): List<String> {
        val list: MutableList<String> = mutableListOf()
        if (null != abilityList) {
            for (ability in abilityList) {
                list.add(ability.name)
            }
        }
        return list
    }

    private fun attacksListToStringList(attackList: List<Attack>?): List<String> {
        val list: MutableList<String> = mutableListOf()
        if (null != attackList) {
            for (attack in attackList) {
                list.add(attack.name)
            }
        }
        return list
    }

    private fun resistancesListToStringList(resistanceList: List<Resistance>?): List<String> {
        val list: MutableList<String> = mutableListOf()
        if (null != resistanceList) {
            for (resistance in resistanceList) {
                list.add(resistance.type.plus(" ").plus(resistance.value))
            }
        }
        return list
    }

    private fun weaknessesListToStringList(weaknessesList: List<Weaknesse>?): List<String> {
        val list: MutableList<String> = mutableListOf()
        if (null != weaknessesList) {
            for (weaknesses in weaknessesList) {
                list.add(weaknesses.type.plus(" ").plus(weaknesses.value))
            }
        }
        return list
    }
}