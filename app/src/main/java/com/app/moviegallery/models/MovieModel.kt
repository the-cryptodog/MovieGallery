package com.app.moviegallery.models

data class MovieModel(
    //Model class for movie model
    val title:String,
    val poster_path :String,
    val release_date:String,
    val movie_id:Int,
    val vote_average:Float,
    val movie_overview:String
)
