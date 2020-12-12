package com.example.proyekakhir

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.description_movie.*

class MovieDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onStart(){
        super.onStart()
        Log.i("MovieDescription", "onStart()")
    }
    override fun onPause() {
        super.onPause()
        Log.i("MovieDescription", "onPause()")
    }
    override fun onResume(){
        super.onResume()
        setContentView(R.layout.description_movie)


        Log.i("MovieDescription", "onResume()")
    }
    override fun onStop() {
        super.onStop()
        Log.i("MovieDescription", "onStop()")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("MovieDescription", "onDestroy()")
    }

}