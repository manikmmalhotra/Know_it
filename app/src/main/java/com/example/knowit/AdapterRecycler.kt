package com.example.knowit
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.knowit.data.Content
import com.squareup.picasso.Picasso


class AdapterRecycler(var context: Context, var response: Content) : RecyclerView.Adapter<AdapterRecycler.ContentAdapter>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentAdapter {
        val layoutInflater = LayoutInflater.from(context)
        val view =
            layoutInflater.inflate(R.layout.particular_item_breaking, parent, false)
        return ContentAdapter(view)
    }

    override fun onBindViewHolder(holder: ContentAdapter, position: Int) {
        holder.sourceName.setText(response.articles!!.get(position).source!!.name.toString())
        holder.sourceTitle.setText(response.articles!!.get(position).title!!.toString())
        if (response.articles!!.get(position).description !=null){
            holder.sourceDescription.setText(response.articles!!.get(position).description!!.toString())
        }
        else{
            holder.sourceDescription.setText("notDefined")
        }

        holder.sourceDate.setText(response.articles!!.get(position).publishedAt!!.toString())
        if(response.articles!!.get(position).author != null){
            holder.sourceAuthor.setText("Author :" + response.articles!!.get(position).author!!.toString())
        }
        else{
            holder.sourceAuthor.setText("Author :" + "undefined")
        }
        if(response.articles!!.get(position).urlToImage!=null){
            Picasso.get().load(response.articles!!.get(position).urlToImage).into(holder.SourceImg)

        }
        else{
            holder.SourceImg
        }
    }

    override fun getItemCount(): Int {
        return response.articles!!.size
    }

    inner class ContentAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var sourceAuthor : TextView
        var sourceTitle : TextView
        var sourceDate : TextView
        var sourceDescription : TextView
        var sourceName : TextView
        var SourceImg : ImageView

        init {

            sourceAuthor = itemView.findViewById(R.id.SourceAuthor)
            sourceDate = itemView.findViewById(R.id.SourceDate)
            sourceDescription = itemView.findViewById(R.id.SourceDescription)
            sourceTitle = itemView.findViewById(R.id.SourceTitle)
            sourceName = itemView.findViewById(R.id.SourceName)
            SourceImg = itemView.findViewById(R.id.SourceImage)

        }
    }

}



