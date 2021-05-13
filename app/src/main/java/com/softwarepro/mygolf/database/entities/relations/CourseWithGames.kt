package com.softwarepro.mygolf.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.softwarepro.mygolf.database.entities.Course
import com.softwarepro.mygolf.database.entities.Game

data class CourseWithGames(
        @Embedded val course: Course,
        @Relation(
            parentColumn = "courseId",
            entityColumn = "courseId"
        )
        val games: List<Game>
)
