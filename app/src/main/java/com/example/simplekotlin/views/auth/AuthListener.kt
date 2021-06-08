package com.example.simplekotlin.views.auth

interface AuthListener {

    fun onStarted() {

    }

    fun onSuccess() {
    }

    fun onFailure(message: String) {
    }

}