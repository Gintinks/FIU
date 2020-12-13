package com.example.proyekakhir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class MovieCommentAdapter(val context: Context, val comments: List<MovieCommentModel>,val id:String, val listener: (MovieCommentModel) -> Unit) :
    RecyclerView.Adapter<MovieCommentAdapter.ViewHolder>(){
    inner class TodoViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCommentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_movie_comment,parent, false)
        return MovieCommentAdapter.ViewHolder(view)

    }
    override fun onBindViewHolder(holder: MovieCommentAdapter.ViewHolder, position: Int) {
        holder.bindItem(comments[position],id, listener)

    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        private val nama_movie = view.findViewById<TextView>(R.id.tv_title)
//        val date = view.findViewById<TextView>(R.id.tv_release_date)
//        val synopsis = view.findViewById<TextView>(R.id.tv_synopsis)
//        val poster = view.findViewById<ImageView>(R.id.iv_poster)
        val nama = view.findViewById<TextView>(R.id.namaComenter)
        val comment = view.findViewById<TextView>(R.id.isiComment)
        fun bindItem(comments: MovieCommentModel,id: String, listener: (MovieCommentModel) -> Unit){
//            nama_movie.text = movies.nama_movie
//            date.text = movies.release_date
//            synopsis.text = movies.sinopsis_movie
//            poster.setImageResource(movies.poster)
//            //itemView.setOnClickListener{ listener(items)}
//            itemView.setOnClickListener{ listener(movies)

            if(comments.id_movie==id){
            nama.text = comments.nama
            comment.text = comments.comment
            itemView.setOnClickListener{ listener(comments)}}
        }
    }

    override fun getItemCount(): Int = comments.size
}

