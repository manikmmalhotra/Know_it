package com.example.knowit
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
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
        holder.weburl.setText(response.articles!!.get(position).url!!.toString())
        if (response.articles!!.get(position).description !=null){
            holder.sourceDescription.setText(response.articles!!.get(position).description!!.toString())
        }
        else{
            holder.sourceDescription.setText("notDefined")
        }

        if (response.articles!!.get(position).urlToImage !=null){
            holder.imgurl.setText(response.articles!!.get(position).urlToImage!!.toString())
        }
        else{
            holder.imgurl.setText("")
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
        holder.bindView(position)
    }

    override fun getItemCount(): Int {
        return response.articles!!.size
    }

    inner class ContentAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var sourceAuthor : TextView
        var sourceTitle : TextView
        var sourceDate : TextView
        var weburl : TextView
        var imgurl : TextView
        var sourceDescription : TextView
        var sourceName : TextView
        var SourceImg : ImageView

        init {

            sourceAuthor = itemView.findViewById(R.id.SourceAuthor)
            sourceDate = itemView.findViewById(R.id.SourceDate)
            weburl = itemView.findViewById(R.id.weburl)
            imgurl = itemView.findViewById(R.id.imgurl)
            sourceDescription = itemView.findViewById(R.id.SourceDescription)
            sourceTitle = itemView.findViewById(R.id.SourceTitle)
            sourceName = itemView.findViewById(R.id.SourceName)
            SourceImg = itemView.findViewById(R.id.SourceImage)

        }
        fun bindView(position:Int){
            itemView.setOnClickListener {
                var intent = Intent(context,web::class.java)
                    .putExtra("name",sourceName.text.toString())
                    .putExtra("author",sourceAuthor.text.toString())
                    .putExtra("title",sourceTitle.text.toString())
                    .putExtra("descr",sourceDescription.text.toString())
                    .putExtra("date",sourceDate.text.toString())
                    .putExtra("web",weburl.text.toString())
                    .putExtra("img",imgurl.text.toString())

                intent.setFlags(FLAG_ACTIVITY_NEW_TASK)
                ContextCompat.startActivity(context,intent,Bundle())
            }
        }
    }

}



