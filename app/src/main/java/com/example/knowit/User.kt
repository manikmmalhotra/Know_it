package com.example.knowit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("articles")
    @Expose
    var articles: List<Article>? = null



}

