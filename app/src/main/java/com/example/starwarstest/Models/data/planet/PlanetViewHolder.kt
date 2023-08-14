package com.example.starwarstest.Models.data.planet

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.starwarstest.Models.data.FavoritesPlanets
import com.example.starwarstest.R
import com.example.starwarstest.View.FavoritesFragment.DeleteItemActionListener
import com.example.starwarstest.View.SearchFragment.AddItemActionListener
import com.google.android.material.chip.Chip

class PlanetViewHolder(itemView: View) :
    ViewHolder(itemView) {
    private val name = itemView.findViewById<TextView>(R.id.tvPlanetName)
    private val diameter = itemView.findViewById<TextView>(R.id.tvPlanetDiametr)
    private val population = itemView.findViewById<TextView>(R.id.tvPopulation)
    private val chip = itemView.findViewById<Chip>(R.id.chipFavorite)

    fun bind(item: Planet, position: Int, clickListener: AddItemActionListener?) {
        name.text = item.name
        diameter.text = item.diameter
        population.text = item.population
        chip.setOnClickListener {
            clickListener?.onAddFavoritePlanetClick(position, item)
        }
    }

    fun favoriteBind(
        item: FavoritesPlanets,
        position: Int,
        clickListener: DeleteItemActionListener?
    ) {
        name.text = item.name
        diameter.text = item.diameter
        population.text = item.population
        chip.isChecked = true
        chip.setOnClickListener {
            clickListener?.onDeleteFavoritePlanetClick(position, item)
        }
    }
}
