package com.example.proyekakhir

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_comment.*


class CommentActivity : AppCompatActivity(){
    var totalRating = 0
    private val PREF_NAME = "Shared"
    private val KEY_ID = "Id"
    private val KEY_NAMA = "Nama"
    private val KEY_COMMENT = "Comment"
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_comment)
        val bundle: Bundle? = intent.extras
        val id = bundle?.get("id").toString()
        var rating = bundle?.get("ratingDes").toString().toInt()
        val commentRepo = MovieCommentRepo(this, id, totalRating)
        val commentVM = MovieCommentViewModel(commentRepo)
        val list = findViewById<RecyclerView>(R.id.rv_main)

        list.adapter = MovieCommentAdapter(this, commentVM.getmovieComments(), id.toString()){}
        list.layoutManager = LinearLayoutManager(this)

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val simpleRatingBar = findViewById<View>(R.id.ratingBar) as RatingBar

        findViewById<Button>(R.id.btn_tambah). setOnClickListener {
            val countRating = ((rating * totalRating) + simpleRatingBar.rating*20)/(totalRating+1)
            totalRating +=1
            val Nrating = countRating.toInt()
            rating = countRating.toInt()
            var nama: String = findViewById<EditText>(R.id.et_nama).text.toString()
            var coment: String = findViewById<EditText>(R.id.et_comment_movie).text.toString()
            val newComment = MovieCommentModel(id, nama, coment)
            commentRepo.tambahMovieComment(newComment)
            list.adapter = MovieCommentAdapter(this, commentVM.getmovieComments(), id.toString()) {}
            list.layoutManager = LinearLayoutManager(this)
            Toast.makeText(applicationContext, """$rating $Nrating""".trimIndent(), Toast.LENGTH_LONG).show()
        }
        val etNamaRestore = sharedPreferences.getString(KEY_NAMA, "0")
        val etCommentRestore = sharedPreferences.getString(KEY_COMMENT, "0")
        et_nama.setText(etNamaRestore)
        et_comment_movie.setText(etCommentRestore)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(KEY_NAMA, et_nama.text.toString())
        editor.putString(KEY_COMMENT, et_comment_movie.text.toString())
        editor.apply()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
    }

}