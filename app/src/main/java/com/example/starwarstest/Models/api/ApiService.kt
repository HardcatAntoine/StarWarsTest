package com.example.starwarstest.Models.api

import com.example.starwarstest.Models.data.people.PeopleResponse
import com.example.starwarstest.Models.data.planet.PlanetResponse
import com.example.starwarstest.Models.data.starships.StarshipsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/people/")
    suspend fun searchPeople(@Query("search") query: String): PeopleResponse

    @GET("api/starships/")
    suspend fun searchStarships(@Query("search") query: String): StarshipsResponse

    @GET("api/planets/")
    suspend fun searchPlanet(@Query("search") query: String): PlanetResponse

}