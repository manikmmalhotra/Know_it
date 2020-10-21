package com.example.knowit.fragments

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.knowit.ContentsAdapter
import com.example.knowit.R
import com.example.knowit.db.ContentDataBase
import com.example.knowit.db.ContentDb
import kotlinx.android.synthetic.main.fragment_fragfour.*
import kotlinx.coroutines.launch


class fragfour : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragfour, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerContent.setHasFixedSize(true)
        recyclerContent.layoutManager = LinearLayoutManager(context!!.applicationContext,
            LinearLayoutManager.VERTICAL,false)

        launch {
            context?.let {
                val contents = ContentDataBase(it).getContentDao().getAllContent()
                recyclerContent.adapter = ContentsAdapter(contents)
            }

        }
    }
}

