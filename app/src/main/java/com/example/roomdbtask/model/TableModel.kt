package com.example.roomdbtask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class TableModel (

    @ColumnInfo(name = "username")
    var Username: String,

    @ColumnInfo(name = "username1")
    var username1: String

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null

}