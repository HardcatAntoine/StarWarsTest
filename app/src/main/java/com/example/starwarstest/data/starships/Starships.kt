package com.example.starwarstest.data.starships

data class Starships(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)