package com.example.roomdbtask

import android.content.Context
import androidx.lifecycle.ViewModel

class UserDataViewModel : ViewModel() {

    fun insertData(context: Context, userData: String, userData1: String) {
       DBListRepository.insertData(context, userData, userData1)
    }



}