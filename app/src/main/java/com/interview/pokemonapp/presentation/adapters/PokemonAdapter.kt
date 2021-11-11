package com.interview.pokemonapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.interview.pokemonapp.R
import com.interview.pokemonapp.data.models.Data
import com.interview.pokemonapp.databinding.PokemonListItemBinding
import com.interview.pokemonapp.presentation.listeners.OnItemClickListener

class PokemonAdapter(private val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: PokemonListItemBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.pokemon_list_item,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position], position)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(val binding: PokemonListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data, position: Int) {
            binding.pokemonName.text = data.name
            if (null != data.level) {
                binding.levelValue.text = data.level
            }
            else {
                binding.levelValue.text = "-"
            }
            binding.hpValue.text = data.hp
            Glide.with(binding.mainImage.context).load(data.images?.small).into(binding.mainImage)
            val tagAdapter = TagAdapter()
            binding.typesRecycler.apply {
                adapter = tagAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
            tagAdapter.differ.submitList(data.types)
            binding.root.setOnClickListener {
                onItemClickListener.onItemClicked(position)
            }
        }
    }
}