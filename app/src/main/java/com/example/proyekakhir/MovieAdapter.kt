package com.example.proyekakhir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val context: Context, val movies: List<movie2>, val listener: (movie2) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    //RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.itemView.apply {
//            val nama_movie = findViewById<TextView>(R.id.tv_title)
//            val date = findViewById<TextView>(R.id.tv_release_date)
//            val synopsis = findViewById<TextView>(R.id.tv_synopsis)
//            val poster = findViewById<ImageView>(R.id.iv_poster)
//            nama_movie.text = todos.value?.get(position)?.nama_movie ?: ""
//            date.text = todos.value?.get(position)?.release_date ?: ""
//            synopsis.text = todos.value?.get(position)?.sinopsis_movie ?: ""
////            todos.value?.get(position)?.image?.let { poster.setImageResource(it.toInt()) }
//
//        }
        holder.bindItem(movies[position], listener)
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val nama_movie = view.findViewById<TextView>(R.id.tv_title)
        val date = view.findViewById<TextView>(R.id.tv_release_date)
        val synopsis = view.findViewById<TextView>(R.id.tv_synopsis)
        val poster = view.findViewById<ImageView>(R.id.iv_poster)
        fun bindItem(movies: movie2, listener: (movie2) -> Unit){
            nama_movie.text = movies.nama_movie
            date.text = movies.release_date
            synopsis.text = movies.sinopsis_movie
            poster.setImageResource(movies.poster)
            //itemView.setOnClickListener{ listener(items)}
            itemView.setOnClickListener{ listener(movies)}
        }
    }
}

