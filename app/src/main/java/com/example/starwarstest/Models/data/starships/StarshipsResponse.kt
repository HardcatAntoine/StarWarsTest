package com.example.starwarstest.Models.data.starships

data class StarshipsResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Starships>
)