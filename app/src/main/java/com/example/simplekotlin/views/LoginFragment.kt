package com.example.simplekotlin.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.simplekotlin.R
import kotlinx.android.synthetic.main.fragment_welcome.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener{
            findNavController().navigate(R.id.mainMovieFragment2)
            Toast.makeText(activity, "Login User", Toast.LENGTH_LONG).show()
        }

    }
}