package com.example.roomdbtask

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(TableModel::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun AppDao() : DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDataseClient(context: Context) : AppDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "TharaniTharan")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}