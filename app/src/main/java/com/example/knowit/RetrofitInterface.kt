package com.example.knowit

import com.example.knowit.data.Content
import retrofit2.Call
import retrofit2.http.GET


interface RetrofitInterface{
    @GET("top-headlines?country=us&apiKey=d08683ea771d44bfa841d1b36d47e77e")
    fun getContent(): Call<Content>

}
