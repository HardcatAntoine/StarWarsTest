package com.example.starwarstest.View.SearchFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.starwarstest.R
import com.example.starwarstest.Models.data.people.People
import com.example.starwarstest.Models.data.people.PeopleViewHolder
import com.example.starwarstest.Models.data.planet.Planet
import com.example.starwarstest.Models.data.planet.PlanetViewHolder
import com.example.starwarstest.Models.data.starships.Starships
import com.example.starwarstest.Models.data.starships.StarshipsViewHolder

open class SearchAdapter<T> : Adapter<RecyclerView.ViewHolder>() {
    private var list = listOf<Any>()
    var clickListener: ItemActionListener? = null

    open fun setOnItemClickListener(clickListener: ItemActionListener) {
        this.clickListener = clickListener
    }

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
            is People -> TYPE_PEOPLE
            is Starships -> TYPE_STARSHIPS
            is Planet -> TYPE_PLANETS
            else -> throw IllegalArgumentException("Error View type")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when {
            item is People && holder is PeopleViewHolder -> holder.bind(item, position, clickListener)
            item is Starships && holder is StarshipsViewHolder -> holder.bind(item, position,clickListener)
            item is Planet && holder is PlanetViewHolder -> holder.bind(item, position,clickListener)
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