package com.example.starwarstest.Models.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    const val BASE_URL = "https://swapi.dev/"
    val pages = 1..42
    private val gsonConverter = GsonConverterFactory.create()
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val httpClient = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(gsonConverter)
        .build()
    private val api = retrofit.create(ApiService::class.java)
    val apiService: ApiService
        get() = api
}