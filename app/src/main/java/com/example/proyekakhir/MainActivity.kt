package com.example.proyekakhir

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var tv_hello: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        setContentView(R.layout.activity_movie_list)
        Log.i("MainActivity", "onStart()")
        val movieRevo = MovieRepository(this)
        val movieVM = MovieViewModel(movieRevo)
        val list = findViewById<RecyclerView>(R.id.lv_movie)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = MovieAdapter(this, movieVM.getMovie()){
            intent = Intent(this, MovieDescription::class.java)
            intent.putExtra("id", it.id)
            intent.putExtra("nama_movie", it.nama_movie)
            intent.putExtra("release_date", it.release_date)
            intent.putExtra("rating", it.rating)
            intent.putExtra("sinopsis_movie", it.sinopsis_movie)
            intent.putExtra("poster",it.poster)
            startActivity(intent)
        }

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
