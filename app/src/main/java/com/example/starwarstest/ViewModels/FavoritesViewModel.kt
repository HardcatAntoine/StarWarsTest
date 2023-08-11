package com.example.starwarstest.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstest.Models.data.FavoritesRepository
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repository: FavoritesRepository) : ViewModel() {

    private var _allFavorites = MutableLiveData<List<Any>>()
    val allFavorites: LiveData<List<Any>>
        get() = _allFavorites

            //Запихать в репозиторий
    fun getAllFavorites() {
        viewModelScope.launch {
            _allFavorites.value = repository.getAllFavorites()
//            val allPeople = repository.getAllPeople()
//            val allStarships = repository.getAllStarships()
//            val allPlanets = repository.getAllPlanets()
//            val allFavoriteList = mutableListOf<Any>()
//            allFavoriteList.addAll(allPeople)
//            allFavoriteList.addAll(allStarships)
//            allFavoriteList.addAll(allPlanets)
//            _allFavorites.value = allFavoriteList
        }
    }
}



