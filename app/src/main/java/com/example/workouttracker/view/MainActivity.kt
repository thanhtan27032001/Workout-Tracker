package com.example.workouttracker.view

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.workouttracker.databinding.ActivityMainBinding
import com.example.workouttracker.model.User
import com.example.workouttracker.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.mainViewModel = MainViewModel(User(
            name = "Nguyễn Thành Tân",
            dateBirth = "",
            gender = "Male",
            national = "",
            weight = 66.0,
            height = 1.71
        ))
        setContentView(binding.root)
    }
}