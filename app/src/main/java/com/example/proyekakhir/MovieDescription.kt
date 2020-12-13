package com.example.proyekakhir

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.description_movie.*
import android.content.Intent
import android.graphics.drawable.Drawable
import android.widget.Button

class MovieDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.description_movie)
        val bundle: Bundle? = intent.extras
        val id = bundle?.get("id")
        val nama_movie : Any? = bundle?.get("nama_movie")
        val release_date : Any? = bundle?.get("release_date")
        val rating : Any? = bundle?.get("rating")
        val sinopsis_movie : Any? = bundle?.get("sinopsis_movie")
        val poster : Any? = bundle?.get("poster")

        tv_title.setText(nama_movie.toString())
        tv_release_date.setText(release_date.toString())
        tv_rating.setText(rating.toString())
        tv_synopsis.setText(sinopsis_movie.toString())
        iv_poster.setImageResource(poster.hashCode())

        val fragComments = FragComment()
        findViewById<Button>(R.id.button). setOnClickListener {
//            supportFragmentManager. beginTransaction().apply {
//                replace(R.id.fragment_comment, fragComments)
//                commit()
//            }
            intent = Intent(this, CommentActivity::class.java)
            intent.putExtra("id", id.toString())
            startActivity(intent)
        }
    }
    override fun onPause() {
        super.onPause()
        Log.i("MovieDescription", "onPause()")
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