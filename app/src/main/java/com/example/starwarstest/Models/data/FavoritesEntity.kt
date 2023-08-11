package com.example.starwarstest.Models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity(tableName = "favorites_people")
@TypeConverters(Converters::class)
data class FavoritesPeople(
    @PrimaryKey val name: String,
    @ColumnInfo("gender") val gender: String,
    @ColumnInfo("starships") val starships: Int,
)

@Entity(tableName = "favorites_starships")
data class FavoritesStarships(
    @PrimaryKey val name: String,
    @ColumnInfo("model") val model: String,
    @ColumnInfo("manufacturer") val manufacturer: String,
    @ColumnInfo("passengers") val passengers: String
)

@Entity(tableName = "favorites_planets")
data class FavoritesPlanets(
    @PrimaryKey val name: String,
    @ColumnInfo("diameter") val diameter: String,
    @ColumnInfo("population") val population: String
)
