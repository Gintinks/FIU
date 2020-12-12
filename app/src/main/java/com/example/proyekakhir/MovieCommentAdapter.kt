package com.example.proyekakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class MovieCommentAdapter(val MovieComments: LiveData<List<MovieCommentModel>>) :
    RecyclerView.Adapter<MovieCommentAdapter.MovieViewHolder>() {
    inner class MovieViewHolder(items: View) : RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.row_movie_comment,parent,false)
        return MovieViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return MovieComments.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.apply{
            val commentMovie = findViewById<TextView>(R.id.namaComenter)
            val nama = findViewById<TextView>(R.id.isiComment)

            nama.text = MovieComments.value?.get(position)?.nama_movie_comment ?: ""
            commentMovie.text = MovieComments.value?.get(position)?.movie_comment ?: ""

        }
    }

}