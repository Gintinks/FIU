package com.example.proyekakhir

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.description_movie.*
import kotlinx.android.synthetic.main.movie_comment.*
import kotlinx.android.synthetic.main.row_movie_comment.*
import kotlin.math.roundToInt

class CommentActivity : AppCompatActivity(){
    var comments : MutableList<MovieCommentModel> = mutableListOf()
    var totalRating = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_comment)
        val bundle: Bundle? = intent.extras
        val id = bundle?.get("id")
        var rating = bundle?.get("ratingDes").toString().toInt()

        initData(id as String)
        val list = findViewById<RecyclerView>(R.id.rv_main)
            list.adapter = MovieCommentAdapter(this, comments, id.toString()) {}
            list.layoutManager = LinearLayoutManager(this)

        val simpleRatingBar = findViewById<View>(R.id.ratingBar) as RatingBar

        findViewById<Button>(R.id.btn_tambah). setOnClickListener {
//            val countRating = ((rating * totalRating) + simpleRatingBar.rating*20)/(totalRating+1)
//             rating = countRating.toInt()
//            tv_rating.setText(rating.toString())
            comments.add(MovieCommentModel(id, R.id.et_nama.toString(), R.id.et_comment_movie.toString()))
        }
    }

    fun initData(id:String){
        val id_comment = resources.getStringArray(R.array.id_movie)
        val nama = resources.getStringArray(R.array.nama)
        val comment = resources.getStringArray(R.array.comment)

       // val rating = resources.getStringArray(R.array.c_rating)

        comments.clear()
        for(i in id_comment.indices){
            if(id_comment[i]==id) {
            comments.add(MovieCommentModel(id_comment[i], nama[i], comment[i]))
            totalRating += 1
            }
        }
    }


}