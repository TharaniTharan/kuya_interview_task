package com.example.roomdbtask.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbtask.R
import com.example.roomdbtask.TableModel
import com.example.roomdbtask.view.ActivityDBList
import com.example.roomdbtask.viewmodel.ListViewModel

class DBListAdapter(var viewModel: ListViewModel, val mData: List<TableModel>) :
    RecyclerView.Adapter<DBListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.listadapter, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textViewUserDataOne.setText(mData[position].Username)
        holder.textViewUserDateTwo.setText(mData[position].username1)

        var currentPosition = mData[position]
        holder.imageViewDelete.setOnClickListener {
            viewModel.delete(currentPosition)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        if (mData.size == 0) {
            return 0
        } else {
            return mData.size
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewUserDataOne =
            itemView.findViewById<View>(R.id.textViewUserDataOne) as AppCompatTextView
        val textViewUserDateTwo =
            itemView.findViewById<View>(R.id.textViewUserDateTwo) as AppCompatTextView
        val imageViewDelete =
            itemView.findViewById<View>(R.id.imageViewDelete) as AppCompatImageView
    }
}