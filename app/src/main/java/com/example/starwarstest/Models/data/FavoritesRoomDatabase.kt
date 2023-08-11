package com.example.starwarstest.Models.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [FavoritesPeople::class, FavoritesStarships::class, FavoritesPlanets::class], version = 1)
@TypeConverters(Converters::class)
abstract class FavoritesRoomDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao


    companion object {
        @Volatile
        private var INSTANCE: FavoritesRoomDatabase? = null

        fun getDatabase(context: Context): FavoritesRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    FavoritesRoomDatabase::class.java,
                    "favorites"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}