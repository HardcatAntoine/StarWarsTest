package com.example.starwarstest.View.FavoritesFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarstest.Models.data.FavoritesPeople
import com.example.starwarstest.Models.data.FavoritesPlanets
import com.example.starwarstest.Models.data.FavoritesStarships
import com.example.starwarstest.Models.data.people.PeopleViewHolder
import com.example.starwarstest.Models.data.planet.PlanetViewHolder
import com.example.starwarstest.Models.data.starships.StarshipsViewHolder
import com.example.starwarstest.R

class FavoriteAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = listOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_PEOPLE -> {
                val peopleView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_people, parent, false)
                PeopleViewHolder(peopleView)
            }

            TYPE_STARSHIPS -> {
                val starshipsView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_starship, parent, false)
                StarshipsViewHolder(starshipsView)
            }

            TYPE_PLANETS -> {
                val planetsView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_planet, parent, false)
                PlanetViewHolder(planetsView)
            }

            else -> throw IllegalArgumentException("Error View type: $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is FavoritesPeople -> TYPE_PEOPLE
            is FavoritesStarships -> TYPE_STARSHIPS
            is FavoritesPlanets -> TYPE_PLANETS
            else -> throw IllegalArgumentException("Error View type")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when {
            item is FavoritesPeople && holder is PeopleViewHolder -> holder.favoriteBind(item)
            item is FavoritesStarships && holder is StarshipsViewHolder -> holder.favoriteBind(item)
            item is FavoritesPlanets && holder is PlanetViewHolder -> holder.favoriteBind(item)
        }


    }

    fun updateDataSet(list: List<Any>) {
        this.list = list
        notifyDataSetChanged()
    }

    companion object {
        private const val TYPE_PEOPLE = 0
        private const val TYPE_STARSHIPS = 1
        private const val TYPE_PLANETS = 2
    }
}