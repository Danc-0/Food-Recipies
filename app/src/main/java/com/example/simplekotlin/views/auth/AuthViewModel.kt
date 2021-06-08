package com.example.simplekotlin.views.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var emailAddress: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun loginBtnClick(view: View) {
        authListener?.onStarted()
        if (emailAddress.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Sorry your details are not correct")
        } else {
            authListener?.onSuccess()
        }
        //Success login
    }

}