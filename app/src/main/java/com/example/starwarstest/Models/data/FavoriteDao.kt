package com.example.starwarstest.Models.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import org.jetbrains.annotations.NotNull


@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorites_people")
    suspend fun getFavoritePeopleList(): List<FavoritesPeople>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPeople(people: FavoritesPeople)

    @Delete
    suspend fun deletePeople(item: FavoritesPeople)

    @Update(entity = FavoritesPeople::class)
    suspend fun updateAllPeople(people: List<FavoritesPeople>)

    @Query("SELECT*FROM favorites_starships")
    suspend fun getFavoritesStarshipsList(): List<FavoritesStarships>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStarship(starships: FavoritesStarships)

    @Delete
    suspend fun deleteStarship(item: FavoritesStarships)

    @Update(entity = FavoritesStarships::class)
    suspend fun updateAllStarships(starships: List<FavoritesStarships>)

    @Query("SELECT*FROM favorites_planets")
    suspend fun getFavoritesPlanetsList(): List<FavoritesPlanets>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlanet(planets: FavoritesPlanets)

    @Delete
    suspend fun deletePlanet(item: FavoritesPlanets)

    @Update(entity = FavoritesPlanets::class)
    suspend fun updateAllPlanets(planets: List<FavoritesPlanets>)


}