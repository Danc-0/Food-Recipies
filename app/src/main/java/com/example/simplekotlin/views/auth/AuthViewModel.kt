package com.example.simplekotlin.views.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.simplekotlin.data.repository.UserRepository

class AuthViewModel : ViewModel() {

    var emailAddress: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun loginBtnClick(view: View) {
        authListener?.onStarted()
        if (emailAddress.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or Password")
        }

        val loginResponse = UserRepository().loginUser(emailAddress!!, password!!)
        authListener?.onSuccess(loginResponse)

    }

}