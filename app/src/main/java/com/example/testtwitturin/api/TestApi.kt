package com.example.testtwitturin.api

import com.example.testtwitturin.data.UserItem
import retrofit2.Call
import retrofit2.http.GET

interface TestApi {

    @GET("users")
    fun getArticle(): Call<List<UserItem>>

}