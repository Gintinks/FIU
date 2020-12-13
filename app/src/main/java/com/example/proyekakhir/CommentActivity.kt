package com.example.proyekakhir

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_movie_comment.*

class CommentActivity : AppCompatActivity(){
    var comments : MutableList<MovieCommentModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_comment)
        initData()
        val bundle: Bundle? = intent.extras
        val id = bundle?.get("id")
        val list = findViewById<RecyclerView>(R.id.rv_main)
        list.adapter = MovieCommentAdapter(this, comments,id.toString()){}
        list.layoutManager = LinearLayoutManager(this)


    }

    fun initData(){
        val id_comment = resources.getStringArray(R.array.id_movie)
        val nama = resources.getStringArray(R.array.nama)
        val comment = resources.getStringArray(R.array.comment)
        comments.clear()
        for(i in id_comment.indices+1){
            comments.add(MovieCommentModel(id_comment[i], nama[i], comment[i]))
        }
    }


}