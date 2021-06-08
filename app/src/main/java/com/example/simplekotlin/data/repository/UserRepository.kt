package com.example.simplekotlin.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplekotlin.data.network.RetrofitInterface
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    private val TAG = "UserRepository"
    fun loginUser(email: String, password: String): LiveData<String> {

        val loginResponse = MutableLiveData<String>()

        RetrofitInterface().loginUser(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>) {

                    if (response.isSuccessful){
                        loginResponse.value = response.body().toString()
                    } else {
                        loginResponse.value = response.errorBody().toString()
                    }

                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                    Log.d(TAG, "onFailure: ${t.message}")
                }

            })

        return loginResponse
    }
}