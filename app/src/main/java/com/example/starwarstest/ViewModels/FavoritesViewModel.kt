package com.example.starwarstest.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstest.Models.data.FavoritesPeople
import com.example.starwarstest.Models.data.FavoritesPlanets
import com.example.starwarstest.Models.data.FavoritesRepository
import com.example.starwarstest.Models.data.FavoritesStarships
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repository: FavoritesRepository) : ViewModel() {

    private var _allFavorites = MutableLiveData<List<Any>>()
    val allFavorites: LiveData<List<Any>>
        get() = _allFavorites

    fun getAllFavorites() {
        viewModelScope.launch {
            _allFavorites.value = repository.getAllFavorites()
        }
    }

    fun deletePeople(people: FavoritesPeople) = viewModelScope.launch {
        repository.deletePeople(people)
    }

    fun deleteStarship(starships: FavoritesStarships) = viewModelScope.launch {
        repository.deleteStarship(starships)
    }

    fun deletePlanet(planets: FavoritesPlanets) = viewModelScope.launch {
        repository.deletePlanet(planets)
    }


}



