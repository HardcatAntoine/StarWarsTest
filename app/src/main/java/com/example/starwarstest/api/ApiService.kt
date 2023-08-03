package com.example.starwarstest.api

import com.example.starwarstest.data.films.Films
import com.example.starwarstest.data.people.People
import com.example.starwarstest.data.starships.Starships
import retrofit2.http.GET

interface ApiService {

    @GET("api/people")
    suspend fun getPersons(): People

    @GET("api/starships")
    suspend fun getStarships(): Starships

    @GET("api/films")
    suspend fun getFilms(): Films
}