package com.softwarepro.mygolf


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment


class CourseDeleteFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_course_delete, container, false)
        var courseName: TextView = root.findViewById(R.id.selectedCourseName)
        var courseLocation: TextView = root.findViewById(R.id.selectedCourseLocation)
        var courseNumber: TextView = root.findViewById(R.id.selectedCourseNumber)
        var deleteButton: Button = root.findViewById(R.id.selectedCourseDeleteButton)

        val type = arrayOf("Thorpe Meadow", "Bourne", "Stamford", "Other", "Example")



        val adapter = ArrayAdapter(activity as Context, android.R.layout.simple_list_item_1, type)
        val spinner: Spinner = root.findViewById(R.id.course_delete_dropdown)
        spinner.setAdapter(adapter)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("Day", "Nothing")
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(spinner.selectedItem.toString() != "Thorpe Meadow") {
                    courseName.text = "Found Item"
                    courseLocation.text = "Peterborough"
                    courseNumber.text = "2"
                    deleteButton.visibility = View.VISIBLE
                }
            }
        }
        return root
    }
}