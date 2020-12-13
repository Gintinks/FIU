package com.example.proyekakhir

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CommentActivity : AppCompatActivity(){
    var comments : MutableList<MovieCommentModel> = mutableListOf()

    var totalRating = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_comment)
        val bundle: Bundle? = intent.extras
        val id = bundle?.get("id").toString()
        var rating = bundle?.get("ratingDes").toString().toInt()
        val commentRepo = MovieCommentRepo(this, id, totalRating)
        val commentVM = MovieCommentViewModel(commentRepo)

        val list = findViewById<RecyclerView>(R.id.rv_main)
            list.adapter = MovieCommentAdapter(this, commentVM.getmovieComments(), id.toString()) {}
            list.layoutManager = LinearLayoutManager(this)

        val simpleRatingBar = findViewById<View>(R.id.ratingBar) as RatingBar

        findViewById<Button>(R.id.btn_tambah). setOnClickListener {
            val countRating = ((rating * totalRating) + simpleRatingBar.rating*20)/(totalRating+1)
            totalRating +=1
            val Nrating = countRating.toInt()
            rating = countRating.toInt()
//            tv_rating.setText(Nrating.toString())
            var nama: String = findViewById<EditText>(R.id.et_nama).text.toString()
            var coment: String = findViewById<EditText>(R.id.et_comment_movie).text.toString()
            var newComment = MovieCommentModel(id, nama, coment)
            commentRepo.tambahMovieComment(newComment)
            list.adapter = MovieCommentAdapter(this, commentVM.getmovieComments(), id.toString()) {}
            list.layoutManager = LinearLayoutManager(this)
            Toast.makeText(applicationContext, """$rating $Nrating""".trimIndent(), Toast.LENGTH_LONG).show()
        }
    }

    fun initData(id:String){
        val id_comment = resources.getStringArray(R.array.id_movie)
        val nama = resources.getStringArray(R.array.nama)
        val comment = resources.getStringArray(R.array.comment)
        comments.clear()
        for(i in id_comment.indices){
            if(id_comment[i]==id) {
            comments.add(MovieCommentModel(id_comment[i], nama[i], comment[i]))
            totalRating += 1
            } else if(totalRating==0){
                totalRating += 1
            }
        }
    }



}