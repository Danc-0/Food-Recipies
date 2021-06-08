package com.example.simplekotlin.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.simplekotlin.R
import com.example.simplekotlin.models.Country
import com.example.simplekotlin.models.MovieResponse
import com.example.simplekotlin.models.SingleMovieResponse
import com.example.simplekotlin.network.CountriesService
import kotlinx.android.synthetic.main.fragment_welcome.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainMovieFragment : Fragment(R.layout.fragment_main_movie) {


    private val TAG = "MainMovieFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retro = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retro.create(CountriesService::class.java)

        val countryRequest = service.listMovies("8ed700250305de124bef08dbb686472a")

        countryRequest.enqueue(object : Callback<SingleMovieResponse> {
            override fun onResponse(call: Call<SingleMovieResponse>, response: Response<SingleMovieResponse>) {
                Log.d(TAG, "onResponse: ${response.isSuccessful}")
                val movieResponse = response.body()
                Log.d(TAG, "onResponse: $movieResponse")

            }

            override fun onFailure(call: Call<SingleMovieResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.localizedMessage}")
            }


        })

    }

    companion object {
        const val URL_COUNTRY_API = "https://restcountries.eu/"
        const val BASE_URL = "https://api.themoviedb.org/"
    }
}