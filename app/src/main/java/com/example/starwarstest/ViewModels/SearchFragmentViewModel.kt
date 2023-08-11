package com.example.starwarstest.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarstest.Models.api.ApiProvider
import com.example.starwarstest.Models.data.FavoritesPeople
import com.example.starwarstest.Models.data.FavoritesPlanets
import com.example.starwarstest.Models.data.FavoritesRepository
import com.example.starwarstest.Models.data.FavoritesStarships
import com.example.starwarstest.Models.data.people.People
import com.example.starwarstest.Models.data.planet.Planet
import com.example.starwarstest.Models.data.starships.Starships
import kotlinx.coroutines.launch

class SearchFragmentViewModel(private val repository: FavoritesRepository) : ViewModel() {


    private val _people = MutableLiveData<List<People>>()
    val people: LiveData<List<People>>
        get() = _people

    private val _starships = MutableLiveData<List<Starships>>()
    val starships: LiveData<List<Starships>>
        get() = _starships

    private val _planet = MutableLiveData<List<Planet>>()
    val planet: LiveData<List<Planet>>
        get() = _planet

    private var queryOption: QueryOption = QueryOption.PEOPLE


    fun searchResult(text: String) {
        if (text.length >= 2) {
            when (queryOption) {
                QueryOption.PEOPLE -> searchPeople(text)
                QueryOption.STARSHIP -> searchStarships(text)
                QueryOption.PLANET -> searchPlanet(text)
            }
        } else {
            text.isEmpty()
        }
    }

    private fun searchPeople(text: String) {
        viewModelScope.launch {
            runCatching {
                val response = ApiProvider.apiService.searchPeople(text)
                _people.value = response.results
            }.onFailure { Log.e("Network error", "Something went wrong") }
        }
    }

    private fun searchStarships(text: String) {
        viewModelScope.launch {
            val response = ApiProvider.apiService.searchStarships(text)
            _starships.value = response.results
        }
    }

    private fun searchPlanet(text: String) {
        viewModelScope.launch {
            val response = ApiProvider.apiService.searchPlanet(text)
            _planet.value = response.results
        }
    }


    enum class QueryOption {
        PEOPLE,
        STARSHIP,
        PLANET
    }


    fun setPeopleQueryOptions() {
        queryOption = QueryOption.PEOPLE
    }

    fun setStarshipQueryOptions() {
        queryOption = QueryOption.STARSHIP
    }

    fun setPlanetQueryOptions() {
        queryOption = QueryOption.PLANET
    }

    fun insertPeople(people: FavoritesPeople) = viewModelScope.launch {
        repository.insertPeople(people)
    }

    fun insertStarship(starships: FavoritesStarships) = viewModelScope.launch {
        repository.insertStarships(starships)
    }

    fun insertPlanet(planets: FavoritesPlanets) = viewModelScope.launch {
        repository.insertPlanet(planets)
    }


}


