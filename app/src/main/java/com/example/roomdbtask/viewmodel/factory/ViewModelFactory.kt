package com.example.roomdbtask.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbtask.DBListRepository
import com.example.roomdbtask.viewmodel.ListViewModel

class ViewModelFactory(private val repository: DBListRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}