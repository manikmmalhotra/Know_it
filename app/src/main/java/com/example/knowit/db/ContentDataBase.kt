package com.example.knowit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ContentDb::class],
    version = 1
)
abstract class ContentDataBase : RoomDatabase(){

    abstract fun getContentDao(): ContentDao

    companion object {
        @Volatile
        private var instance : ContentDataBase? = null
        private val LOCK = Any()

        operator  fun invoke(context: Context) = instance ?: synchronized(LOCK){
             instance ?: buildDatabase(context).also {
                 instance = it
             }

        }


        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ContentDataBase::class.java,
            "contentdatabase"
        ).build()
    }

}