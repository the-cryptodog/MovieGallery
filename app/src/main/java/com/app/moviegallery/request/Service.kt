package com.app.moviegallery.request

import com.app.moviegallery.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Service {
    val okHttpClient = OkHttpClient()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Credentials.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun gerApiService(): MovieApi = retrofit.create(MovieApi::class.java)
}