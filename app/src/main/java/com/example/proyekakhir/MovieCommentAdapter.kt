package com.example.proyekakhir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class MovieCommentAdapter(val context: Context, val comments:  LiveData<List<MovieCommentModel>>,val id:String, val listener: (MovieCommentModel) -> Unit) :
    RecyclerView.Adapter<MovieCommentAdapter.MovieCommentViewHolder>(){
    inner class MovieCommentViewHolder(items: View): RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCommentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.row_movie_comment,parent, false)
        return MovieCommentViewHolder(layoutInflater)

    }
    override fun onBindViewHolder(holder: MovieCommentViewHolder, position: Int) {
        holder.itemView.apply {
            val nama = findViewById<TextView>(R.id.namaComenter)
            val comment = findViewById<TextView>(R.id.isiComment)


            nama.text = comments.value?.get(position)?.nama?: ""
            comment.text = comments.value?.get(position)?.comment?: ""

        }
        holder.itemView.setOnClickListener{ listener(comments.value?.get(position)?: return@setOnClickListener) }

    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val nama = view.findViewById<TextView>(R.id.namaComenter)
        val comment = view.findViewById<TextView>(R.id.isiComment)
        fun bindItem(comments: MovieCommentModel,id: String, listener: (MovieCommentModel) -> Unit){

            if(comments.id_movie==id){
            nama.text = comments.nama
            comment.text = comments.comment
            itemView.setOnClickListener{ listener(comments)}}
        }
    }

    override fun getItemCount(): Int {
        return comments.value?.size ?: 0
    }
}

