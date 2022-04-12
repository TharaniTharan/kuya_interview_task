package com.example.roomdbtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAOAccess {

    @Insert()
    suspend fun insertData(tableModel: TableModel)

    @Query("SELECT * FROM Task")
    fun getDetails(): LiveData<List<TableModel>>

    @Delete
    suspend fun delete(item: TableModel)

}