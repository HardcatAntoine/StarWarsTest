package com.example.starwarstest.View.SearchFragment

import com.example.starwarstest.Models.data.people.People
import com.example.starwarstest.Models.data.planet.Planet
import com.example.starwarstest.Models.data.starships.Starships

interface ItemActionListener {
    fun onAddFavoritePeopleClick(position: Int, item: People)
    fun onAddFavoriteStarshipClick(position: Int, item: Starships)
    fun onAddFavoritePlanetClick(position: Int, item: Planet)
}