package com.example.starwarstest.Models.data.planet

data class PlanetResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Planet>
)