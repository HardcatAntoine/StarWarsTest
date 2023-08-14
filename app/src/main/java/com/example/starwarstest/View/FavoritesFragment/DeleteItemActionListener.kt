package com.example.starwarstest.View.FavoritesFragment

import com.example.starwarstest.Models.data.FavoritesPeople
import com.example.starwarstest.Models.data.FavoritesPlanets
import com.example.starwarstest.Models.data.FavoritesStarships

interface DeleteItemActionListener {

    fun onDeleteFavoritePeopleClick(position: Int, item: FavoritesPeople)
    fun onDeleteFavoriteStarshipClick(position: Int, item: FavoritesStarships)
    fun onDeleteFavoritePlanetClick(position: Int, item: FavoritesPlanets)
}