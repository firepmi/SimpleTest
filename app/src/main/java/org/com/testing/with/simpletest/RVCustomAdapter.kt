package org.com.testing.with.simpletest

import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter(private val dataSet: List<Article>) :
    RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView
        val contentTextView: TextView
        val imageView: ImageView

        init {
            titleTextView = view.findViewById(R.id.mTextViewTitle)
            contentTextView = view.findViewById(R.id.mTextViewContent)
            imageView = view.findViewById(R.id.mImageViewCardViewItem)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = dataSet[position].title
        holder.contentTextView.text = dataSet[position].content
        Picasso.get().load(dataSet[position].imageURL).into(holder.imageView)
    }
}