package com.app.moviegallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.app.moviegallery.models.MovieModel
import com.app.moviegallery.request.MovieSearchResponse
import com.app.moviegallery.request.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MovieListActivity : AppCompatActivity() {

    lateinit var name :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        name = findViewById(R.id.movieName)

        btn.setOnClickListener {
            getRetrofitResponseAccordingToID()
        }
    }

    private fun initView(){

    }

    private fun getRetrofitResponse() {
        val service = Service.gerApiService()
        val responseCall: Call<MovieSearchResponse> =
            service.searchMovie(Credentials.API_KEY, "Action", 1)
        responseCall.enqueue(object : Callback<MovieSearchResponse> {
            override fun onResponse(
                call: Call<MovieSearchResponse>,
                response: Response<MovieSearchResponse>
            ) {
                if (response.code() == 200) {
//                    Log.d("Tag", "the response = "+response.body().toString())
                    val list: List<MovieModel>? = response.body()?.movies
                    if (list != null) {
                        for (element in list) {
                            Log.d("Tag", element.title.toString())
                        }
                    }
                } else {
                    try {
                        Log.d("Tag", "error =" + response.errorBody().toString())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun getRetrofitResponseAccordingToID(){
        val service = Service.gerApiService()
        val callResponse:Call<MovieModel> = service.getMovie(551,Credentials.API_KEY)
        callResponse.enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
               if(response.code() ==200){
                   val movie  = response.body()
                   name.text = movie?.title.toString()
                   Log.d("Tag","Thread name is ${Thread.currentThread().name}")
               }else{
                   try {
                       Log.d("Tag", "error =" + response.errorBody().toString())
                   } catch (e: IOException) {
                       e.printStackTrace()
                   }
               }
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {

            }
        })
    }
}