package com.example.proyekakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
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
        movies.clear()
        for(i in ratingArray.indices){
            movies.add(movie2(i, nameArray[i], dateArray[i], synopsisArray[i], ratingArray[i]))
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
        //val todoVM = TodoViewMovie(MovieRepository())
        //val adapter = TodoAdapter(todoVM.getTodos())
        //val rvTodo = findViewById<RecyclerView>(R.id.lv_movie)
        //rvTodo.adapter = adapter
        //rvTodo.layoutManager = LinearLayoutManager(this)
        val list = findViewById<RecyclerView>(R.id.lv_movie)
        initData()
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = MovieAdapter(this, movies){
            val toast = Toast.makeText(applicationContext, it.nama_movie, Toast.LENGTH_SHORT)
            toast.show()
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
