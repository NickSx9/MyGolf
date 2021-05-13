package com.softwarepro.mygolf.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.softwarepro.mygolf.database.entities.Booking
import com.softwarepro.mygolf.database.entities.Course

data class CourseWithBookings(
        @Embedded val course: Course,
        @Relation(
                parentColumn = "courseId",
                entityColumn = "courseId"
        )
        val bookings: List<Booking>
)
