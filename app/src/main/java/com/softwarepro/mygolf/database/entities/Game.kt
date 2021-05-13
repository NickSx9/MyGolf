package com.softwarepro.mygolf.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
@PrimaryKey(autoGenerate = true)
val gameId: Long = 0L,
val courseId: Long,
val date: String,
val playerName: String,
val holeOne: String,
val holeTwo: String,
val holeThree: String,
val holeFour: String,
val holeFive: String,
val holeSix: String,
val holeSeven: String,
val holeEight: String,
val holeNine: String,
val holeTen: String,
val holeEleven: String,
val holeTwelve: String ,
val holeThirteen: String ,
val holeFourteen: String ,
val holeFifteen: String ,
val holeSixteen: String ,
val holeSeventeen: String ,
val holeEighteen: String ,
val playedHoleOne: String ,
val playedHoleTwo: String ,
val playedHoleThree: String,
val playedHoleFour: String ,
val playedHoleFive: String ,
val playedHoleSix: String ,
val playedHoleSeven: String ,
val playedHoleEight: String ,
val playedHoleNine: String ,
val playedHoleTen: String ,
val playedHoleEleven: String ,
val playedHoleTwelve: String ,
val playedHoleThirteen: String ,
val playedHoleFourteen: String ,
val playedHoleFifteen: String ,
val playedHoleSixteen: String ,
val playedHoleSeventeen: String ,
val playedHoleEighteen: String
)
