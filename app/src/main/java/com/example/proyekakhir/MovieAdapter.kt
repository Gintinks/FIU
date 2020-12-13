package com.example.proyekakhir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val context: Context, val movies: LiveData<List<MovieModel>>, val listener: (MovieModel) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    inner class MovieViewHolder(items: View): RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent, false)
        return MovieViewHolder(layoutInflater)
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.apply {
            val nama_movie = findViewById<TextView>(R.id.tv_title)
            val date = findViewById<TextView>(R.id.tv_release_date)
            val synopsis = findViewById<TextView>(R.id.tv_synopsis)
            val poster = findViewById<ImageView>(R.id.iv_poster)

                nama_movie.text = movies.value?.get(position)?.nama_movie?: ""
                date.text = movies.value?.get(position)?.release_date?: ""
                synopsis.text = movies.value?.get(position)?.sinopsis_movie?: ""
                movies.value?.get(position)?.poster?.let { poster.setImageResource(it) }
        }
        holder.itemView.setOnClickListener{ listener(movies.value?.get(position)?: return@setOnClickListener) }
    }

    override fun getItemCount(): Int {
        return movies.value?.size ?: 0
    }

}

