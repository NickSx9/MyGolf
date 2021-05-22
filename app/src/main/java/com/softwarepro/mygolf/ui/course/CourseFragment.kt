package com.softwarepro.mygolf.ui.course

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.softwarepro.mygolf.PostsAdapter
import com.softwarepro.mygolf.R
import com.softwarepro.mygolf.database.entities.Course
import java.util.*

 lateinit var courses: MutableList<Course>

class CourseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        courses = MutableList<Course>(10, init = {
            i: Int -> addCourse(i)
        })

        var root = inflater.inflate(R.layout.fragment_course, container, false)

        var recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = PostsAdapter(courses)
        val snapHelper: SnapHelper = LinearSnapHelper()

        snapHelper.attachToRecyclerView(recyclerView)
        var addButton: BottomNavigationItemView = root.findViewById(R.id.bottom_menuAdd)
        var editButton: BottomNavigationItemView = root.findViewById(R.id.bottom_menuEdit)
        var deleteButton: BottomNavigationItemView = root.findViewById(R.id.bottom_menuDelete)

        addButton.setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_nav_course_to_courseAddFragment)
        }
        editButton.setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_nav_course_to_courseEditFragment)
        }
        deleteButton.setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_nav_course_to_courseDeleteFragment)
        }
        return root
    }
    private fun addCourse(x: Int) :Course{
        var addCourse = Course(
                courseLocation =   "Peterborough",
                courseName = "Thorpe Meadows $x",
                userId = x.toLong(),
                courseNumber = "0173356395$x",
                holeOne = "3",
                holeTwo = "4",
                holeThree = "5" ,
                holeFour = "4" ,
                holeFive = "4",
                holeSix = "4" ,
                holeSeven = "3",
                holeEight = "4" ,
                holeNine = "4" ,
                holeTen = "3" ,
                holeEleven = "4",
                holeTwelve = "4",
                holeThirteen = "3",
                holeFourteen = "4",
                holeFifteen = "3",
                holeSixteen = "4",
                holeSeventeen = "5",
                holeEighteen = "3"
        )
        return addCourse
    }
}