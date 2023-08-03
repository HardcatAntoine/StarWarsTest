package com.example.starwarstest.data.people

data class People(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)