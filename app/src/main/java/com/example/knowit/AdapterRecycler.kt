package com.example.knowit
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterRecycler {
    (var context: Context, var response: User) : RecyclerView.Adapter<CountryHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
            val layoutInflater = LayoutInflater.from(context)
            val view =
                layoutInflater.inflate(R.layout.particular_item_breaking, parent, false)
            return CountryHolder(view)
        }

        override fun onBindViewHolder(holder: CountryHolder, position: Int) {

        }
        override fun getItemCount(): Int {
            return response.categories       !!.size
        }

        inner class CountryHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            var imageView: ImageView
            var textView: TextView

            init {


            }
            fun bindView(position: Int) {

                }


            }

        }

    }

