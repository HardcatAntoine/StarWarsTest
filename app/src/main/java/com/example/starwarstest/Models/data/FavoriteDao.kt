package com.example.starwarstest.Models.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorites_people")
    suspend fun getFavoritePeopleList(): List<FavoritesPeople>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPeople(people: FavoritesPeople)

    @Delete
    suspend fun deletePeople(item: FavoritesPeople)

    @Query("SELECT*FROM favorites_starships")
    suspend fun getFavoritesStarshipsList(): List<FavoritesStarships>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStarship(starships: FavoritesStarships)

    @Query("SELECT*FROM favorites_planets")
    suspend fun getFavoritesPlanetsList(): List<FavoritesPlanets>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlanet(planets: FavoritesPlanets)

}