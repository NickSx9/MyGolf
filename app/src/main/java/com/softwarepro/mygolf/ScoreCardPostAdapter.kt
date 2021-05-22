package com.softwarepro.mygolf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.softwarepro.mygolf.model.CouseDetails
import com.softwarepro.mygolf.model.PlayingPlayers
import com.softwarepro.mygolf.ui.course.courses

class ScoreCardPostAdapter(private val player: String, private val courseHole: CouseDetails) : RecyclerView.Adapter<ScoreCardPostAdapter.PostsViewHolder>() {

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.playerName.text = "$player"
        holder.holeOne.text = "Par " + courseHole.holeOne
        holder.holeTwo.text = "Par " + courseHole.holeTwo
        holder.holeThree.text = "Par " + courseHole.holeThree
        holder.holeFour.text = "Par " + courseHole.holeFour
        holder.holeFive.text = "Par " + courseHole.holeFive
        holder.holeSix.text = "Par " + courseHole.holeSix
        holder.holeSeven.text = "Par " + courseHole.holeSeven
        holder.holeEight.text = "Par " + courseHole.holeEight
        holder.holeNine.text = "Par " + courseHole.holeNine
        holder.holeTen.text = "Par " + courseHole.holeTen
        holder.holeEleven.text = "Par " + courseHole.holeEleven
        holder.holeTwelve.text = "Par " + courseHole.holeTwelve
        holder.holeThirteen.text = "Par " + courseHole.holeThirteen
        holder.holeFourteen.text = "Par " + courseHole.holeFourteen
        holder.holeFifteen.text = "Par " + courseHole.holeFifteen
        holder.holeSixteen.text = "Par " + courseHole.holeSixteen
        holder.holeSeventeen.text = "Par " + courseHole.holeSeventeen
        holder.holeEighteen.text = "Par " + courseHole.holeEighteen
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ScoreCardPostAdapter.PostsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.score_card_score_even, parent, false)
        return ScoreCardPostAdapter.PostsViewHolder(view)
    }

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val playerName: TextView = itemView.findViewById(R.id.playerCardName)

        val holeOne: TextView = itemView.findViewById(R.id.playerScore_1)
        val holeTwo: TextView = itemView.findViewById(R.id.playerScore_2)
        val holeThree: TextView = itemView.findViewById(R.id.playerScore_3)
        val holeFour: TextView = itemView.findViewById(R.id.playerScore_4)
        val holeFive: TextView = itemView.findViewById(R.id.playerScore_5)
        val holeSix: TextView = itemView.findViewById(R.id.playerScore_6)
        val holeSeven: TextView = itemView.findViewById(R.id.playerScore_7)
        val holeEight: TextView = itemView.findViewById(R.id.playerScore_8)
        val holeNine: TextView = itemView.findViewById(R.id.playerScore_9)
        val holeTen: TextView = itemView.findViewById(R.id.playerScore_10)
        val holeEleven: TextView = itemView.findViewById(R.id.playerScore_11)
        val holeTwelve: TextView = itemView.findViewById(R.id.playerScore_12)
        val holeThirteen: TextView = itemView.findViewById(R.id.playerScore_13)
        val holeFourteen: TextView = itemView.findViewById(R.id.playerScore_14)
        val holeFifteen: TextView = itemView.findViewById(R.id.playerScore_15)
        val holeSixteen: TextView = itemView.findViewById(R.id.playerScore_16)
        val holeSeventeen: TextView = itemView.findViewById(R.id.playerScore_17)
        val holeEighteen: TextView = itemView.findViewById(R.id.playerScore_18)

    }
}