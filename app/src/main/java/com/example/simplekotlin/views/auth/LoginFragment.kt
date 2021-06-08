package com.example.simplekotlin.views.auth

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simplekotlin.R
import com.example.simplekotlin.databinding.FragmentLoginBinding
import com.example.simplekotlin.utils.toastMessage
import kotlinx.android.synthetic.main.fragment_welcome.*

class LoginFragment : Fragment(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: FragmentLoginBinding = DataBindingUtil.setContentView(context as Activity, R.layout.fragment_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.authViewModel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        super.onStarted()
        Toast.makeText(context, "Login started", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess() {
        super.onSuccess()
        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(message: String) {
        super.onFailure(message)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}