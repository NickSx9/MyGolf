package com.softwarepro.mygolf.database.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        User::class,
        Course::class,
        Game::class,
        Booking::class
    ],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            synchronized(this ){
                return INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "MyGolf_db"
                ).build().also{
                    INSTANCE = it
                }
            }
        }
    }
}