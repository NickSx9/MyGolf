package com.softwarepro.mygolf.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
        @PrimaryKey(autoGenerate = true)
        val courseId: Long =0L,
        var userId: Long,
        var courseName: String ,
        var courseNumber: String ,
        var courseLocation: String ,
        var holeOne: String ,
        var holeTwo: String ,
        var holeThree: String ,
        var holeFour: String ,
        var holeFive: String ,
        var holeSix: String ,
        var holeSeven: String ,
        var holeEight: String ,
        var holeNine: String ,
        var holeTen: String ,
        var holeEleven: String,
        var holeTwelve: String,
        var holeThirteen: String,
        var holeFourteen: String,
        var holeFifteen: String,
        var holeSixteen: String,
        var holeSeventeen: String,
        var holeEighteen: String
)