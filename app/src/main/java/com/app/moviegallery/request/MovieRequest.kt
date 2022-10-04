package com.app.moviegallery.request

import com.app.moviegallery.models.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieRequest(
    @SerializedName("results")val MovieModel: MovieModel,
)
