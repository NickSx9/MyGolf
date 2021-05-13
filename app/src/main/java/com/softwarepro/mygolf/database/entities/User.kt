package com.softwarepro.mygolf.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
        @PrimaryKey(autoGenerate = true)
        val userId: Long = 0L,
        val fullName: String,
        val emailAddress: String,
        val password: String
)