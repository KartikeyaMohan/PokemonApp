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
        if (null != pokemon.level) {
            binding.levelValue.text = pokemon.level
        }
        else {
            binding.levelValue.text = "-"
        }
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
        if (null != pokemon.subtypes) {
            subTypeAdapter.differ.submitList(pokemon.subtypes)
        }
        else {
            binding.subTypes.visibility = View.GONE
            binding.subTypesRecycler.visibility = View.GONE
            binding.dividerSix.visibility = View.GONE
        }
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
        else {
            binding.abilities.visibility = View.GONE
            binding.abilitiesRecycler.visibility = View.GONE
            binding.dividerFour.visibility = View.GONE
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
        else {
            binding.attacks.visibility = View.GONE
            binding.attacksRecycler.visibility = View.GONE
            binding.dividerFive.visibility = View.GONE
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
        else {
            binding.resistances.visibility = View.GONE
            binding.resistancesRecycler.visibility = View.GONE
            binding.dividerSeven.visibility = View.GONE
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
        else {
            binding.weaknesses.visibility = View.GONE
            binding.weaknessesRecycler.visibility = View.GONE
        }
        return list
    }
}