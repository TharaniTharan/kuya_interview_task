package com.example.roomdbtask.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomdbtask.DBListRepository
import com.example.roomdbtask.TableModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel(private val repository: DBListRepository) : ViewModel() {

    var liveData: LiveData<List<TableModel>>? = null

    fun getLoginDetails(context: Context): LiveData<List<TableModel>>? {
        liveData = DBListRepository.getDetails(context)
        return liveData
    }

    fun delete(item: TableModel) = GlobalScope.launch {
        repository.delete(item)
    }
}