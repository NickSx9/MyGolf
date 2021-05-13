package com.softwarepro.mygolf.ui.course

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.softwarepro.mygolf.PostsAdapter
import com.softwarepro.mygolf.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CourseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val courses: ArrayList<String> = ArrayList()
        for(i in 1..10){
            courses.add("course Number #$i")
        }

        var root = inflater.inflate(R.layout.fragment_course, container, false)
        var recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = PostsAdapter(courses)

        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        return root
    }
}