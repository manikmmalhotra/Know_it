package com.example.knowit.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContentDb(
    val name: String,
    val author:String,
    val title: String,
    val url:String,
    val urlToImage: String,
    val publishedAt:String,
    val description:String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}