package com.example.proyekakhir

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var movies: MutableList<movie2> = mutableListOf()
    fun initData(){
        val ratingArray = resources.getStringArray(R.array.movie_rating)
//    val posterArray: Array<Int> = resources.getStringArray(R.array.movie_poster)
        val nameArray = resources.getStringArray(R.array.movie_title)
        val synopsisArray = resources.getStringArray(R.array.movie_synopsis)
        val dateArray = resources.getStringArray(R.array.movie_release_date)
        val imageArray = resources.obtainTypedArray(R.array.movie_poster)
//        val drawableIds = IntArray(imageArray.length())
//        val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.poster_mortalengine, null)
//        for (i in 0 until imageArray.length()) {
//            drawableIds[i] = imageArray.getResourceId(i, 0)
//        }
//        imageArray.recycle();
        val myImageList = intArrayOf(R.drawable.poster_aquaman,R.drawable.poster_avengerinfinity,R.drawable.poster_birdbox,
            R.drawable.poster_bumblebee,R.drawable.poster_dragon,R.drawable.poster_glass,R.drawable.poster_mortalengine,R.drawable.poster_robinhood
        ,R.drawable.poster_spiderman,R.drawable.poster_venom)
        movies.clear()

        for(i in ratingArray.indices){

            movies.add(movie2(i, nameArray[i], dateArray[i], synopsisArray[i], ratingArray[i],myImageList[i]))
        }
    }

    lateinit var tv_hello: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val movie_Comment_Repo = MovieCommentRepo()
//        val movieCommentViewModel = MovieCommentViewModel(movie_Comment_Repo)
//        val rvMain = findViewById<RecyclerView>(R.id.rv_main)
//        rvMain.adapter = MovieCommentAdapter(movieCommentViewModel.getmovieComments())
//        rvMain.layoutManager = LinearLayoutManager(this)

//        findViewById<Button>(R.id.btn_tambah).setOnClickListener {
//            val movie_comment = findViewById<EditText>(R.id.et_comment_movie).text.toString()
//            val nama = findViewById<EditText>(R.id.et_nama).text.toString()
//            if(!movie_comment.isEmpty()&&!nama.isEmpty()) {
//                movieCommentViewModel.tambahMovieComments(MovieCommentModel("$movie_comment","$nama"))
//                rvMain.adapter = MovieCommentAdapter(movieCommentViewModel.getmovieComments())
//                rvMain.layoutManager = LinearLayoutManager(this)
//            }else{
//                Toast.makeText(applicationContext, "isi kolom yang kosong", Toast.LENGTH_SHORT).show()
//            }
//        }

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
        val list = findViewById<RecyclerView>(R.id.lv_movie)
        initData()
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = MovieAdapter(this, movies){
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
