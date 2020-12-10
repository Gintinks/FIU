package com.example.proyekakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var tv_hello: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onStart()")

        val movie_Comment_Repo = MovieCommentRepo()
        val movieCommentViewModel = MovieCommentViewModel(movie_Comment_Repo)
        val rvMain = findViewById<RecyclerView>(R.id.rv_main)
        rvMain.adapter = MovieCommentAdapter(movieCommentViewModel.getmovieComments())
        rvMain.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btn_tambah).setOnClickListener {
            val movie_comment = findViewById<EditText>(R.id.et_comment_movie).text.toString()
            val nama = findViewById<EditText>(R.id.et_nama).text.toString()
            if(!movie_comment.isEmpty()&&!nama.isEmpty()) {
                movieCommentViewModel.tambahMovieComments(MovieCommentModel("$movie_comment","$nama"))
                rvMain.adapter = MovieCommentAdapter(movieCommentViewModel.getmovieComments())
                rvMain.layoutManager = LinearLayoutManager(this)
            }else{
                Toast.makeText(applicationContext, "isi kolom yang kosong", Toast.LENGTH_SHORT).show()
            }
        }

    }
    override fun onStart(){
        super.onStart()
        Log.i("MainActivity", "onStart()")
    }
    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause()")
    }
    override fun onResume(){
        super.onResume()
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "onResume()")
    }
    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop()")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy()")
    }


}
