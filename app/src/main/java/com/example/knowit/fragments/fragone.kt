package com.example.knowit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knowit.AdapterRecycler
import com.example.knowit.Model.ApiClient
import com.example.knowit.R
import com.example.knowit.data.Content
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class fragone : Fragment() {

    lateinit var apiclient: ApiClient
    lateinit var recyclerView: RecyclerView
    lateinit var progress: ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apiclient = ApiClient()
        recyclerView = view.findViewById(R.id.recyclerViewone)
        progress = view.findViewById(R.id.progress)
        val call =
            ApiClient.apiinterface.getContent()

        call.enqueue(object : Callback<Content>{
            override fun onFailure(call: Call<Content>, t: Throwable) {

            }

            override fun onResponse(call: Call<Content>, response: Response<Content>) {
                progress.visibility = View.GONE
                var recyclerAdapter: AdapterRecycler =
                    AdapterRecycler(
                        context!!.applicationContext,
                        response.body()!!
                    )
                recyclerView.adapter = recyclerAdapter
                recyclerView.layoutManager = LinearLayoutManager(context!!.applicationContext,LinearLayoutManager.VERTICAL,false)
            }

        } )

    }


}