package com.example.roomdbtask

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DBListRepository(private val db: AppDatabase) {

    companion object {

        var appDatabase: AppDatabase? = null

        var tableModel: LiveData<List<TableModel>>? = null

        fun initializeDB(context: Context) : AppDatabase {
            return AppDatabase.getDataseClient(context)
        }

        fun insertData(context: Context, valueOne: String, valueTwo: String) {

            appDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val dataDetails = TableModel(valueOne, valueTwo)
                appDatabase!!.AppDao().insertData(dataDetails)
            }

        }

        fun getDetails(context: Context) : LiveData<List<TableModel>>? {

            appDatabase = initializeDB(context)

            tableModel = appDatabase!!.AppDao().getDetails()

            return tableModel
        }

    }
    suspend fun delete(item:TableModel) = db.AppDao().delete(item)
}