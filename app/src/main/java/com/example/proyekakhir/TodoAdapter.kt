package com.example.proyekakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(var todos: LiveData<List<movie2>>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent, false)
        return TodoViewHolder(view)
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            val nama_movie = findViewById<TextView>(R.id.tv_title)
            val date = findViewById<TextView>(R.id.tv_release_date)
            val synopsis = findViewById<TextView>(R.id.tv_synopsis)
            val poster = findViewById<ImageView>(R.id.iv_poster)
            nama_movie.text = todos.value?.get(position)?.nama_movie ?: ""
            date.text = todos.value?.get(position)?.release_date ?: ""
            synopsis.text = todos.value?.get(position)?.sinopsis_movie ?: ""
//            todos.value?.get(position)?.image?.let { poster.setImageResource(it.toInt()) }

        }
    }

    override fun getItemCount(): Int {
        return todos.value?.size ?: 0
    }
}
