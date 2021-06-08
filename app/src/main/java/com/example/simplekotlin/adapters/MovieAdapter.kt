package com.example.simplekotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData() {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = parent
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
//        return movieList.size
        TODO("Not yet implemented")
    }

}