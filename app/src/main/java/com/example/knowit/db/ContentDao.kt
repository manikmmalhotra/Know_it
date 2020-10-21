package com.example.knowit.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContentDao {

    @Insert
    fun addContent(content:ContentDb)

    @Query("SELECT * FROM ContentDb ORDER BY id DESC")
    suspend fun getAllContent():List<ContentDb>

}