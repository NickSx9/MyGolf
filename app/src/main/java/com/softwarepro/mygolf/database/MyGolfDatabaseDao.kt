package com.softwarepro.mygolf.database

import androidx.room.*

@Dao
interface UserDataDatabaseDao {
    @Insert
    suspend fun insert(userData: UserData)
    @Update
    suspend fun update(userData: UserData)
    @Query("DELETE FROM myGolf_user_table")
    suspend fun clear()
    @Query("SELECT * FROM myGolf_user_table Where emailAddress = :email AND password = :password")
    suspend fun findUserDetails(email: String, password: String) : UserData
    @Query("SELECT * FROM myGolf_user_table")
    suspend fun getUserDataList() : List<UserData>
}
@Dao
interface CourseDataDatabaseDao {
    @Insert
    suspend fun insert(courseData: CourseData)
    @Update
    suspend fun update(courseData: CourseData)
    @Query("DELETE FROM myGolf_course_table")
    suspend fun clear()
    @Query("SELECT * FROM myGolf_course_table")
    suspend fun getCourseDataList() : List<CourseData>
}
@Dao
interface RoundDataDatabaseDao {
    @Insert
    suspend fun insert(roundData: RoundData)
    @Update
    suspend fun update(roundData: RoundData)
    @Query("DELETE FROM myGolf_round_table")
    suspend fun clear()
    @Query("SELECT * FROM myGolf_round_table")
    suspend fun getRoundDataList() : List<RoundData>
}
@Dao
interface BookingDataDatabaseDao {
    @Insert
    suspend fun insert(bookingData: BookingData)
    @Update
    suspend fun update(bookingData: BookingData)
    @Query("DELETE FROM myGolf_bookings_table")
    suspend fun clear()
    @Query("SELECT * FROM myGolf_bookings_table")
    suspend fun getBookingDataList() : List<BookingData>
}