package com.example.roomdbtask.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbtask.AppDatabase
import com.example.roomdbtask.DBListRepository
import com.example.roomdbtask.TableModel
import com.example.roomdbtask.databinding.ActivityDatabaseListBinding
import com.example.roomdbtask.view.adapter.DBListAdapter
import com.example.roomdbtask.viewmodel.ListViewModel
import com.example.roomdbtask.viewmodel.factory.ViewModelFactory

class ActivityDBList : AppCompatActivity() {

    lateinit var ViewModel: ListViewModel
    private lateinit var binding: ActivityDatabaseListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDatabaseListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dbListRepository = DBListRepository(AppDatabase.getDataseClient(this))

        val factory =
            ViewModelFactory(dbListRepository)

        ViewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)

        binding.recyclerViewData.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerViewData.setItemAnimator(DefaultItemAnimator())
        binding.recyclerViewData.setNestedScrollingEnabled(false)

        ViewModel.getLoginDetails(this)!!.observe(this, Observer {

            if (it != null) {
                Log.e("it->", listOf(it).size.toString())
                val adapter = DBListAdapter(ViewModel, it as List<TableModel>)
                binding.recyclerViewData.setAdapter(adapter)
            } else {
                Log.e("it->", listOf(it).size.toString())
            }
        })
    }
}