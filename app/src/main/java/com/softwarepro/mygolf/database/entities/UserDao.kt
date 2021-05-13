package com.softwarepro.mygolf.database.entities

import androidx.room.*
import com.softwarepro.mygolf.database.entities.relations.CourseWithBookings
import com.softwarepro.mygolf.database.entities.relations.CourseWithGames
import com.softwarepro.mygolf.database.entities.relations.UserWithCourses

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user Where emailAddress = :email AND password = :password")
    suspend fun findUserDetails(email: String, password: String) : User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: Course)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: Game)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooking(booking: Booking)

    @Transaction
    @Query("Select * FROM user WHERE userId = :userId")
    suspend fun getUserWithCourses(userId: Long): List<UserWithCourses>

    @Transaction
    @Query("Select * FROM course WHERE userId = :courseId")
    suspend fun getCourseWithGames(courseId: Long): List<CourseWithGames>

    @Transaction
    @Query("Select * FROM course WHERE userId = :courseId")
    suspend fun getCourseWithBookings(courseId: Long): List<CourseWithBookings>

}