package com.example.starwarstest.Models.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class FavoritesRepository(private val favoriteDao: FavoriteDao) {

    @WorkerThread
    suspend fun getAllPeople(): List<FavoritesPeople> {
        return favoriteDao.getFavoritePeopleList()
    }


    @WorkerThread
    suspend fun getAllStarships(): List<FavoritesStarships> {
        return favoriteDao.getFavoritesStarshipsList()
    }

    @WorkerThread
    suspend fun getAllPlanets(): List<FavoritesPlanets> {
        return favoriteDao.getFavoritesPlanetsList()
    }

    @WorkerThread
    suspend fun insertPeople(people: FavoritesPeople) {
        favoriteDao.insertPeople(people)
    }

    @WorkerThread
    suspend fun insertStarships(starships: FavoritesStarships) {
        favoriteDao.insertStarship(starships)
    }

    @WorkerThread
    suspend fun insertPlanet(planets: FavoritesPlanets) {
        favoriteDao.insertPlanet(planets)
    }

    @WorkerThread
    suspend fun getAllFavorites(): List<Any> {
        val allFavoritesList = mutableListOf<Any>()
        allFavoritesList.addAll(favoriteDao.getFavoritePeopleList())
        allFavoritesList.addAll(favoriteDao.getFavoritesStarshipsList())
        allFavoritesList.addAll(favoriteDao.getFavoritesStarshipsList())
        return allFavoritesList
    }
}