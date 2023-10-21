package com.example.testtwitturin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.testtwitturin.api.TestApi
import com.example.testtwitturin.data.UserItem
import com.example.testtwitturin.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://localhost:10443/api/"
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        parseData()
    }
    
    private fun parseData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TestApi::class.java)

        val retrofitData = retrofitBuilder.getArticle()
        retrofitData.enqueue(object : Callback<List<UserItem>?> {
            override fun onResponse(call: Call<List<UserItem>?>, response: Response<List<UserItem>?>) {
                val responseBody = response.body()!!
                for (myData in responseBody){
                    binding.tv.text = myData.name
                }
            }

            override fun onFailure(call: Call<List<UserItem>?>, t: Throwable) {
                binding.tv.text = t.message.toString()
                Log.d("TAG","onFailure" + t.message)
            }
        })
    }
}