package com.example.knowit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.knowit.db.ContentDb
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.particular_item_breaking.view.*

class ContentsAdapter(private val contents: List<ContentDb>) : RecyclerView.Adapter<ContentsAdapter.COntentViewHolder>(){


    class COntentViewHolder(val view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): COntentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =
            layoutInflater.inflate(R.layout.particular_item_breaking, parent, false)
        return COntentViewHolder(view)
    }

    override fun getItemCount()= contents.size


    override fun onBindViewHolder(holder: COntentViewHolder, position: Int) {

        holder.view.SourceName.text = contents[position].name
        holder.view.SourceAuthor.text = contents[position].author
        holder.view.SourceDate.text = contents[position].publishedAt
        holder.view.SourceTitle.text = contents[position].title
        holder.view.SourceDescription.text = contents[position].description
        holder.view.weburl.text = contents[position].url
        Picasso.get().load(contents[position].urlToImage.toString()).into(holder.view.SourceImage)
    }
}
