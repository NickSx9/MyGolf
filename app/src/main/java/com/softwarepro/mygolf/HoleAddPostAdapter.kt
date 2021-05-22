package com.softwarepro.mygolf

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HoleAddPostAdapter(val courses: ArrayList<String> ) : RecyclerView.Adapter<HoleAddPostAdapter.PostsViewHolder>(){

    override fun getItemCount() = courses.size

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.courseHole.text = courses[position]
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_addcourse, parent, false)
        return PostsViewHolder(view)
    }

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val courseHole: TextView = itemView.findViewById(R.id.holeNumber)
    }
}