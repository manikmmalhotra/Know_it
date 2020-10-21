package com.example.knowit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knowit.AdapterRecycler
import com.example.knowit.Model.ApiClient
import com.example.knowit.R
import com.example.knowit.data.Content
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class fragthree : Fragment() {

    lateinit var apiclient: ApiClient
    lateinit var recyclerView: RecyclerView
    lateinit var q : EditText
    lateinit var btn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragthree, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiclient = ApiClient()
        recyclerView = view.findViewById(R.id.recylerSearch)
        q = view.findViewById(R.id.editText)
        btn = view.findViewById(R.id.Searchbb)

        btn.setOnClickListener{
            val call = ApiClient.apiinterface.getSearch(q.text.toString(),"d08683ea771d44bfa841d1b36d47e77e")

            call.enqueue(object : Callback<Content> {
                override fun onFailure(call: Call<Content>, t: Throwable) {

                }
                override fun onResponse(call: Call<Content>, response: Response<Content>) {
                    var recyclerAdapter: AdapterRecycler =
                        AdapterRecycler(
                            context!!.applicationContext,
                            response.body()!!
                        )
                    recyclerView.adapter = recyclerAdapter
                    recyclerView.layoutManager = LinearLayoutManager(context!!.applicationContext,
                        LinearLayoutManager.VERTICAL,false)
                }

            } )
        }


    }

    }