package com.example.simplekotlin.network

import com.example.simplekotlin.models.Country
import com.example.simplekotlin.models.MovieResponse
import com.example.simplekotlin.models.SingleMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountriesService {

     @GET("/rest/v2/all")
     fun listCountries(): Call<List<Country>>

     @GET("/3/movie/popular")
     fun listMovies(@Query("api_key") apiKey: String): Call<SingleMovieResponse>
 }

