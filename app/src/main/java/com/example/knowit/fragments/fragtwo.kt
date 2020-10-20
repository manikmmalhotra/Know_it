package com.example.knowit.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knowit.AdapterRecycler
import com.example.knowit.Model.ApiClient
import com.example.knowit.R
import com.example.knowit.data.Content
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class fragtwo : Fragment() {

    lateinit var countrySpinner : Spinner
    lateinit var categorySpinner : Spinner
    lateinit var recylerview : RecyclerView
    lateinit var apiclient: ApiClient
    lateinit var butn:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragtwo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countrySpinner = view.findViewById(R.id.Countries)
        categorySpinner = view.findViewById(R.id.Categories)
        recylerview = view.findViewById(R.id.RecyclerFilter)
        butn = view.findViewById(R.id.submitButton)
        apiclient = ApiClient()


        val countries = arrayOf("ae" ,"ar", "at", "au","be", "bg" ,"br" ,"ca" ,"ch", "cn" ,"co", "cu", "cz" ,"de", "eg" ,"fr", "gb", "gr" ,"hk", "hu", "id", "ie" ,"il" ,"in" ,"it", "jp", "kr", "lt" ,"lv", "ma" ,"mx", "my" ,"ng" ,"nl" ,"no", "nz" ,"ph" ,"pl" ,"pt" ,"ro" ,"rs", "ru" ,"sa" ,"se" ,"sg" ,"si" ,"sk" ,"th", "tr", "tw", "ua", "us", "ve" ,"za")
        val categories = arrayOf("business", "entertainment", "general", "health" ,"science", "sports", "technology")

        countrySpinner.adapter = ArrayAdapter<String>(context!!.applicationContext,android.R.layout.simple_list_item_1,countries)
        categorySpinner.adapter = ArrayAdapter<String>(context!!.applicationContext,android.R.layout.simple_list_item_1,categories)

        var con:String? = null
        var cat:String? = null


        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                con = countries.get(position)
            }

        }

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                cat = categories.get(position)

            }

        }
        
        butn.setOnClickListener {
            val call =
                ApiClient.apiinterface.getFilter(con!!,cat!!,"d08683ea771d44bfa841d1b36d47e77e")

            call.enqueue(object : Callback<Content> {
                override fun onFailure(call: Call<Content>, t: Throwable) {

                }

                override fun onResponse(call: Call<Content>, response: Response<Content>) {
                    var recyclerAdapter: AdapterRecycler =
                        AdapterRecycler(
                            context!!.applicationContext,
                            response.body()!!
                        )
                    recylerview.adapter = recyclerAdapter
                    recylerview.layoutManager = LinearLayoutManager(context!!.applicationContext,
                        LinearLayoutManager.VERTICAL,false)
                }

            } )

        }



    }

}