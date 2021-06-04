package com.example.simplekotlin.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.simplekotlin.R
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin.setOnClickListener{
            findNavController().navigate(R.id.loginFragment)
        }

        btnLogin.setOnClickListener{
            findNavController().navigate(R.id.registerFragment)

        }

    }
}