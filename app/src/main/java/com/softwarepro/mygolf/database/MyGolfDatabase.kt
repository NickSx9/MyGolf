package com.softwarepro.mygolf.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class UserDataDatabase : RoomDatabase() {
    abstract val userDataDatabaseDao: UserDataDatabaseDao
    companion object {
        @Volatile
        private var INSTANCE: UserDataDatabase? = null
        fun getInstance(context: Context): UserDataDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDataDatabase::class.java,
                        "myGolf_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
@Database(entities = [CourseData::class], version = 1, exportSchema = false)
abstract class CourseDataDatabase : RoomDatabase() {
    abstract val courseDataDatabaseDao: CourseDataDatabaseDao
    companion object {
        @Volatile
        private var INSTANCE: CourseDataDatabase? = null
        fun getInstance(context: Context): CourseDataDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CourseDataDatabase::class.java,
                        "myGolf_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
@Database(entities = [RoundData::class], version = 1, exportSchema = false)
abstract class RoundDataDatabase : RoomDatabase() {
    abstract val roundDataDatabaseDao: RoundDataDatabaseDao
    companion object {
        @Volatile
        private var INSTANCE: RoundDataDatabase? = null
        fun getInstance(context: Context): RoundDataDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoundDataDatabase::class.java,
                        "myGolf_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
@Database(entities = [BookingData::class], version = 1, exportSchema = false)
abstract class BookingDataDatabase : RoomDatabase() {
    abstract val bookingDataDatabaseDao: BookingDataDatabaseDao
    companion object {
        @Volatile
        private var INSTANCE: BookingDataDatabase? = null
        fun getInstance(context: Context): BookingDataDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BookingDataDatabase::class.java,
                        "myGolf_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

