package com.softwarepro.mygolf.ui.score

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets.Side.BOTTOM
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.softwarepro.mygolf.PostsAdapter
import com.softwarepro.mygolf.R
import com.softwarepro.mygolf.ScoreCardPostAdapter
import com.softwarepro.mygolf.model.CouseDetails
import com.softwarepro.mygolf.model.PlayingPlayers
import com.softwarepro.mygolf.ui.course.courses

class ScoreFragment : Fragment() {
    var numberOfPlayers = 0
    lateinit var scoreLayout: LinearLayoutCompat
    var listOfPlayerNames: ArrayList<String> = ArrayList()
    lateinit var editText: EditText
    lateinit var recyclerView: RecyclerView
    var firstPass = true
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_score, container, false)
        scoreLayout = root.findViewById(R.id.scoreConstraintLayout)

        var numberPlayerLayout: TextInputLayout = root.findViewById(R.id.numberOfPlayers)
        var numberOfPlayersTextField: TextInputEditText = root.findViewById(R.id.numberPlayers)

        var playerNameLayout: TextInputLayout = root.findViewById(R.id.playerName)
        var playerNames: TextInputEditText = root.findViewById(R.id.playerNames)
        var buttonCount: Button = root.findViewById(R.id.buttonCount)
        var addButton: Button = root.findViewById(R.id.addPlayer)
        //need to be feed by database
        val type = arrayOf("Thorpe Meadow", "Bourne", "Stamford", "Other", "Example")


        buttonCount.setOnClickListener {
            numberOfPlayers = numberOfPlayersTextField?.text.toString()?.toInt()
            buttonCount.visibility = View.GONE
            numberOfPlayersTextField.visibility = View.GONE
            numberPlayerLayout.visibility = View.GONE
            playerNameLayout.visibility = View.VISIBLE
            playerNames.visibility = View.VISIBLE
            addButton.visibility = View.VISIBLE
        }
        addButton.setOnClickListener {
            if (numberOfPlayers == 1) {
                playerNameLayout.visibility = View.GONE
                playerNames.visibility = View.GONE
                addButton.visibility = View.GONE
            }
            listOfPlayerNames.add(playerNames?.text.toString())
            var name = playerNames?.text.toString()
            Toast.makeText(context, "$name has been added the score card", Toast.LENGTH_SHORT).show()
            playerNames?.text?.clear()
            numberOfPlayers--
            cardLoop(root, name)
        }

        val adapter = ArrayAdapter(activity as Context, android.R.layout.simple_list_item_1, type)
        val spinner: Spinner = root.findViewById(R.id.course_score_dropdown)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("Day", "Nothing")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
        return root
    }

    private fun cardLoop(root: View, name: String) {
        recyclerView = RecyclerView(activity as Context)
        recyclerView.layoutParams = LinearLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT, // width
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        recyclerView.id = View.generateViewId()
        scoreLayout.addView(recyclerView)
        recyclerView(root, name, demoData(), recyclerView)
        Log.d("cardLoop", "name - $name " + "id = " + recyclerView.id)
    }

    private fun recyclerView(root: View, player: String, courseDetails: CouseDetails, viewId: View) {
        var recyclerView: RecyclerView = root.findViewById(viewId.id)
        recyclerView.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ScoreCardPostAdapter(player, courseDetails)
        if (firstPass) {
            val snapHelper: SnapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
            firstPass = false
        }
    }
    //needs to be feed by database
    private fun demoData(): CouseDetails {
        return CouseDetails(
                holeOne = "3",
                holeTwo = "4",
                holeThree = "5",
                holeFour = "3",
                holeFive = "4",
                holeSix = "4",
                holeSeven = "5",
                holeEight = "3",
                holeNine = "4",
                holeTen = "5",
                holeEleven = "5",
                holeTwelve = "4",
                holeThirteen = "4",
                holeFourteen = "4",
                holeFifteen = "3",
                holeSixteen = "5",
                holeSeventeen = "5",
                holeEighteen = "4",
        )
    }
}


//            for (i in 0..numberOfPlayers) {
//
//                numberOfPlayers--
//            }
//
//var firstPass = true
//var prevResponseId = 0
//for ((q, a) in model.questionResponse) {
//
//    val question = TextView(context)
//    val response = TextView(context)
//
//    question.gravity = Gravity.CENTER
//    response.gravity = Gravity.CENTER
//
//    question.text = q
//    response.text = a
//
//    question.id = View.generateViewId()
//    response.id = View.generateViewId()
//
//    constraintLayout_book.addView(question, params)
//    constraintLayout_book.addView(response, params)
//
//    val constraintSet = ConstraintSet()
//    constraintSet.clone(constraintLayout_book)
//
//    //Question
//    if (firstPass) {
//        constraintSet.connect(R.id.book_word_cloud, BOTTOM, question.id, ConstraintSet.TOP)
//        constraintSet.connect(question.id, ConstraintSet.TOP, R.id.book_word_cloud, ConstraintSet.BOTTOM)
//    } else {
//        val prevResponse: TextView = view.findViewById<TextView>(prevResponseId)
//        constraintSet.connect(prevResponse.id, ConstraintSet.BOTTOM, question.id, ConstraintSet.TOP)
//        constraintSet.connect(question.id, ConstraintSet.TOP, prevResponse.id, ConstraintSet.BOTTOM)
//    }
//
//    constraintSet.connect(question.id, ConstraintSet.START, R.id.constraintLayout_book, ConstraintSet.START)
//    constraintSet.connect(question.id, ConstraintSet.END, R.id.constraintLayout_book, ConstraintSet.END)
//    constraintSet.connect(question.id, ConstraintSet.BOTTOM, response.id, ConstraintSet.TOP)
//    //Response
//    constraintSet.connect(response.id, ConstraintSet.TOP, question.id, ConstraintSet.BOTTOM)
//    constraintSet.connect(response.id, ConstraintSet.START, R.id.constraintLayout_book, ConstraintSet.START)
//    constraintSet.connect(response.id, ConstraintSet.END, R.id.constraintLayout_book, ConstraintSet.END)
//    constraintSet.connect(response.id, ConstraintSet.BOTTOM, R.id.book_guideline_footer, ConstraintSet.TOP)
//    firstPass = false
//    prevResponseId = response.id
//    constraintSet.applyTo(constraintLayout_book)
//}