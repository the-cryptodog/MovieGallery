package com.app.moviegallery.request

import com.app.moviegallery.Credentials
import com.app.moviegallery.models.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApi {

    //Search for movies
    //https://api.themoviedb.org/3/movie/popular?api_key={api_key}&language=en-US&page=1
    @GET("3/search/movie")
    fun searchMovie(
        @Query("api_key")key: String,
        @Query("query")query :String,
        @Query("page") page:Int):Call<MovieSearchResponse>

    //Making Search with ID
    //https://api.themoviedb.org/3/movie/popular?api_key={api_key}&language=en-US&page=1
    @GET("3/movie/{movie_id}")
    fun getMovie(
      @Path("movie_id") movie_id: Int,
      @Query("api_key")key: String
    ):Call<MovieModel>
}