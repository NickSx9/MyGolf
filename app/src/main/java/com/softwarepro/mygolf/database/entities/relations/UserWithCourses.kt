package com.softwarepro.mygolf.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.softwarepro.mygolf.database.entities.Course
import com.softwarepro.mygolf.database.entities.User

data class UserWithCourses(
        @Embedded val user: User,
        @Relation(
                 parentColumn = "userId",
                entityColumn = "userId"
        )
        val courses: List<Course>
)
