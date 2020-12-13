package com.example.proyekakhir

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_movie_comment.*

class CommentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_comment)
        val id_comment = resources.getStringArray(R.array.id_movie)
        val nama = resources.getStringArray(R.array.nama)
        val comment = resources.getStringArray(R.array.comment)
        for(i in id_comment.indices){
            comments.add(MovieCommentModel(id_comment[i], nama[i], comment[i]))
        }
        val bundle: Bundle? = intent.extras
        val id = bundle?.get("id")
        val list = findViewById<RecyclerView>(R.id.rv_main)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = MovieCommentAdapter(this, comments){}

    }
    var comments : MutableList<MovieCommentModel> = mutableListOf()
    fun initData(){
        val id_comment = resources.getStringArray(R.array.id_movie)
        val nama = resources.getStringArray(R.array.nama)
        val comment = resources.getStringArray(R.array.comment)
        for(i in id_comment.indices){
            comments.add(MovieCommentModel(id_comment[i], nama[i], comment[i]))
        }
    }


}