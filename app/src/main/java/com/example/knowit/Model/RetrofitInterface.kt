package com.example.knowit.Model

import com.example.knowit.data.Content
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface{
    @GET("top-headlines?country=us&apiKey=d08683ea771d44bfa841d1b36d47e77e")
    fun getContent(): Call<Content>

    @GET("top-headlines")
    fun getFilter(
        @Query("country") country:String,
        @Query("category") category:String,
        @Query("apiKey") apiKey:String
    ): Call<Content>

    @GET("everything")
    fun getSearch(
        @Query("q") querry:String,
        @Query("apiKey") apiKey:String
    ): Call<Content>

}
