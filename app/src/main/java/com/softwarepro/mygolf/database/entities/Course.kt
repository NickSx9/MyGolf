package com.softwarepro.mygolf.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
        @PrimaryKey(autoGenerate = true)
        val courseId: Long =0L,
        val userId: Long,
        val courseName: String ,
        val courseNumber: String ,
        val courseLocation: String ,
        val holeOne: String ,
        val holeTwo: String ,
        val holeThree: String ,
        val holeFour: String ,
        val holeFive: String ,
        val holeSix: String ,
        val holeSeven: String ,
        val holeEight: String ,
        val holeNine: String ,
        val holeTen: String ,
        val holeEleven: String,
        val holeTwelve: String,
        val holeThirteen: String,
        val holeFourteen: String,
        val holeFifteen: String,
        val holeSixteen: String,
        val holeSeventeen: String,
        val holeEighteen: String
)