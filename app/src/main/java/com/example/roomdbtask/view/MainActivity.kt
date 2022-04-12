package com.example.roomdbtask.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbtask.UserDataViewModel
import com.example.roomdbtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: UserDataViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(UserDataViewModel::class.java)


        binding.buttonView.setOnClickListener {
            startActivity(Intent(this, ActivityDBList::class.java))
        }
        binding.buttonSubmit.setOnClickListener {


            if (binding.editTextFirstData.text!!.trim().isEmpty()) {
                binding.editTextFirstData.error = "Please enter the Value"
            } else if (binding.editTextSecondData.text!!.trim().isEmpty()) {
                binding.editTextSecondData.error = "Please enter the Value"
            } else {
                if (binding.editTextFirstData.text!!.length >= 8 && binding.editTextSecondData.text!!.length >= 8) {
                    viewModel.insertData(
                        this,
                        binding.editTextFirstData.text!!.trim().toString(),
                        binding.editTextSecondData.text!!.trim().toString()
                    )
                    Toast.makeText(this, "Insert Successfully", Toast.LENGTH_LONG).show()
                    binding.editTextFirstData.setText("")
                    binding.editTextSecondData.setText("")
                } else {
                    Toast.makeText(this, "Min 8 Characters", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}