package com.example.testtwitturin.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: TestApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost:3001/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TestApi::class.java)
    }
}