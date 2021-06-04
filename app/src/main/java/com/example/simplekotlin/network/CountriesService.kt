package com.example.simplekotlin.network

import com.example.simplekotlin.models.Country
import com.example.simplekotlin.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountriesService {

     @GET("/rest/v2/all")
     fun listCountries(): Call<List<Country>>

     @GET("/3/movie/550")
     fun listMovies(@Query("api_key") apiKey: String): Call<MovieResponse>
 }

