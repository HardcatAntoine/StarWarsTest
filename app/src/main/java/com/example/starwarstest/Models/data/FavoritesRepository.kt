package com.example.starwarstest.Models.data

import androidx.annotation.WorkerThread

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
    suspend fun deletePeople(people: FavoritesPeople) {
        favoriteDao.deletePeople(people)
    }

    @WorkerThread
    suspend fun updatePeople(peoples: List<FavoritesPeople>) {
        favoriteDao.updateAllPeople(peoples)
    }


    @WorkerThread
    suspend fun insertStarships(starships: FavoritesStarships) {
        favoriteDao.insertStarship(starships)
    }

    @WorkerThread
    suspend fun deleteStarship(starships: FavoritesStarships) {
        favoriteDao.deleteStarship(starships)
    }

    @WorkerThread
    suspend fun updateStarships(starships: List<FavoritesStarships>) {
        favoriteDao.updateAllStarships(starships)
    }

    @WorkerThread
    suspend fun insertPlanet(planets: FavoritesPlanets) {
        favoriteDao.insertPlanet(planets)
    }

    @WorkerThread
    suspend fun deletePlanet(planets: FavoritesPlanets) {
        favoriteDao.deletePlanet(planets)
    }

    @WorkerThread
    suspend fun updatePlanets(planets: List<FavoritesPlanets>) {
        favoriteDao.updateAllPlanets(planets)
    }

    @WorkerThread
    suspend fun getAllFavorites(): List<Any> {
        val allFavoritesList = mutableListOf<Any>()
        val allPeople = favoriteDao.getFavoritePeopleList()
        val allStarships = favoriteDao.getFavoritesStarshipsList()
        val allPlanets = favoriteDao.getFavoritesPlanetsList()

        val updatePeoples = favoriteDao.updateAllPeople(allPeople)
        val updateStarships = favoriteDao.updateAllStarships(allStarships)
        val updatePlanets = favoriteDao.updateAllPlanets(allPlanets)

        allFavoritesList.addAll(allPeople)
        allFavoritesList.addAll(allStarships)
        allFavoritesList.addAll(allPlanets)
        return allFavoritesList
    }
}
