package com.example.starwarstest

import android.app.Application
import com.example.starwarstest.Models.data.FavoritesRepository
import com.example.starwarstest.Models.data.FavoritesRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class FavoriteApplication : Application() {
    val db by lazy { FavoritesRoomDatabase.getDatabase(this) }
    val repository by lazy { FavoritesRepository(db.favoriteDao()) }
}