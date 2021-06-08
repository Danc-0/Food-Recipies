package com.example.simplekotlin.views.auth

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplekotlin.R
import com.example.simplekotlin.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), AuthListener {

    private val TAG = "LoginFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: FragmentLoginBinding = DataBindingUtil.setContentView(context as Activity, R.layout.fragment_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.authViewModel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        Toast.makeText(context, "Login started", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onSuccess: $it")
        })

    }

    override fun onFailure(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}