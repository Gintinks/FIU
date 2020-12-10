package com.example.proyekakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    val ratingArray: Array<String> = resources.getStringArray(R.array.movie_rating)
    val posterArray: Array<String> = resources.getStringArray(R.array.movie_poster)
    val nameArray: Array<String> = resources.getStringArray(R.array.movie_title)
    val synopsisArray: Array<String> = resources.getStringArray(R.array.movie_synopsis)
    val dateArray: Array<String> = resources.getStringArray(R.array.movie_release_date)
    val movieRepo = MovieRepository(ratingArray, posterArray, nameArray, synopsisArray, dateArray)

    lateinit var tv_hello: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onStart()")
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
