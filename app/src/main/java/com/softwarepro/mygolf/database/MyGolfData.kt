package com.softwarepro.mygolf.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL

@Entity(tableName = "myGolf_user_table")
data class UserData(
        @PrimaryKey(autoGenerate = true)
        var userId: Long = 0L,

        @ColumnInfo(name = "first_name")
        var firstName: String = "",

        @ColumnInfo(name = "emailAddress")
        var emailAddress: String = "",

        @ColumnInfo(name = "password")
        var password: String = "",
)
@Entity(tableName = "myGolf_course_table")
data class CourseData(
        @PrimaryKey(autoGenerate = true)
        var courseId: Long = 0L,

        @ColumnInfo(name = "userId")
        var userId: Long = 0L,

        @ColumnInfo(name = "course_name")
        var courseName: String = "",

        @ColumnInfo(name = "course_number")
        var courseNumber: String = "",

        @ColumnInfo(name = "course_location")
        var courseLocation: String = "",
)

@Entity(tableName = "myGolf_round_table")
data class RoundData(
        @PrimaryKey(autoGenerate = true)
        var roundId: Long = 0L,

        @ColumnInfo(name = "courseId")
        var courseId: Long = 0L,

        @ColumnInfo(name = "date")
        var date: String? = "",

        @ColumnInfo(name = "hole_one")
        var holeOne: String = "",

        @ColumnInfo(name = "hole_two")
        var holeTwo: String = "",

        @ColumnInfo(name = "hole_three")
        var holeThree: String = "",

        @ColumnInfo(name = "hole_four")
        var holeFour: String = "",

        @ColumnInfo(name = "hole_five")
        var holeFive: String = "",

        @ColumnInfo(name = "hole_six")
        var holeSix: String = "",

        @ColumnInfo(name = "hole_seven")
        var holeSeven: String = "",

        @ColumnInfo(name = "hole_eight")
        var holeEight: String = "",

        @ColumnInfo(name = "hole_nine")
        var holeNine: String = "",

        @ColumnInfo(name = "hole_ten")
        var holeTen: String = "",

        @ColumnInfo(name = "hole_eleven")
        var holeEleven: String = "",

        @ColumnInfo(name = "hole_twelve")
        var holeTwelve: String = "",

        @ColumnInfo(name = "hole_thirteen")
        var holeThirteen: String = "",

        @ColumnInfo(name = "hole_fourteen")
        var holeFourteen: String = "",

        @ColumnInfo(name = "hole_fifteen")
        var holeFifteen: String = "",

        @ColumnInfo(name = "hole_sixteen")
        var holeSixteen: String = "",

        @ColumnInfo(name = "hole_seventeen")
        var holeSeventeen: String = "",

        @ColumnInfo(name = "hole_eighteen")
        var holeEighteen: String = "",

        @ColumnInfo(name = "played_hole_one")
        var playedHoleOne: String = "",

        @ColumnInfo(name = "played_hole_two")
        var playedHoleTwo: String = "",

        @ColumnInfo(name = "played_hole_three")
        var playedHoleThree: String = "",

        @ColumnInfo(name = "played_hole_four")
        var playedHoleFour: String = "",

        @ColumnInfo(name = "played_hole_five")
        var playedHoleFive: String = "",

        @ColumnInfo(name = "played_hole_six")
        var playedHoleSix: String = "",

        @ColumnInfo(name = "played_hole_seven")
        var playedHoleSeven: String = "",

        @ColumnInfo(name = "played_hole_eight")
        var playedHoleEight: String = "",

        @ColumnInfo(name = "played_hole_nine")
        var playedHoleNine: String = "",

        @ColumnInfo(name = "played_hole_ten")
        var playedHoleTen: String = "",

        @ColumnInfo(name = "played_hole_eleven")
        var playedHoleEleven: String = "",

        @ColumnInfo(name = "played_hole_twelve")
        var playedHoleTwelve: String = "",

        @ColumnInfo(name = "played_hole_thirteen")
        var playedHoleThirteen: String = "",

        @ColumnInfo(name = "played_hole_fourteen")
        var playedHoleFourteen: String = "",

        @ColumnInfo(name = "played_hole_fifteen")
        var playedHoleFifteen: String = "",

        @ColumnInfo(name = "played_hole_sixteen")
        var playedHoleSixteen: String = "",

        @ColumnInfo(name = "played_hole_seventeen")
        var playedHoleSeventeen: String = "",

        @ColumnInfo(name = "played_hole_eighteen")
        var playedHoleEighteen: String = ""
)
@Entity(tableName = "myGolf_bookings_table")
data class BookingData(
        @PrimaryKey(autoGenerate = true)
        var bookingId: Long = 0L,

        @ColumnInfo(name = "courseId")
        var courseId: Long = 0L,

        @ColumnInfo(name = "date")
        var date: String = "",

        @ColumnInfo(name = "date_booked")
        var dateBooked: String = "",

        @ColumnInfo(name = "number_of_players")
        var playersCount: String = "",
)