package com.app.moviegallery

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Service {

    val okHttpClient = OkHttpClient()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Credentials.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun gerApiService(): MovieApi = retrofit.create(MovieApi::class.java)
}