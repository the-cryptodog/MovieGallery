package com.app.moviegallery.request

import com.app.moviegallery.models.MovieModel
import com.google.gson.annotations.SerializedName

//This class is for getting multiple movies (Moview List) - popular movies
data class MovieSearchResponse(
    @SerializedName("total_results") val total_results :Int,
    @SerializedName("results") val movies :List<MovieModel>,
    )
