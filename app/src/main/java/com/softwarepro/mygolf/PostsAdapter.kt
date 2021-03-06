package com.softwarepro.mygolf

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.softwarepro.mygolf.database.entities.Course

class PostsAdapter(val courses: List<Course> ) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>(){

    override fun getItemCount() = courses.size


    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.courseName.text = courses[position].courseName
        holder.courseLocation.text = courses[position].courseLocation
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsViewHolder {
       val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_course, parent, false)
        return PostsViewHolder(view)
    }

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val courseName: TextView = itemView.findViewById(R.id.courseName)
        val courseLocation: TextView = itemView.findViewById(R.id.courseLocation)
    }
}
//https://www.youtube.com/watch?v=MBCuvneFEp0   6.39