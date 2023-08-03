package com.example.starwarstest.data.films

data class Films(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)