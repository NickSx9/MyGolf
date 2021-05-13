package com.softwarepro.mygolf.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Booking(
@PrimaryKey(autoGenerate = true)
val bookingId: Long =0L,
val courseId: Long,
var date: String,
var dateBooked: String,
var playersCount: String,
)

