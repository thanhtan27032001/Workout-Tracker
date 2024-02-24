package com.example.workouttracker.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.workouttracker.R
import com.example.workouttracker.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var imgAvatar: ImageView
    private lateinit var tvUserName: TextView
    private lateinit var tvUserStatus: TextView

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setView()
        observeLiveData()
    }

    private fun observeLiveData() {
        mainViewModel.userInfo.observe(this) { newUserInfo ->
            tvUserName.text = newUserInfo.name
            tvUserStatus.text = newUserInfo.getUserStatus()
        }
    }

    private fun setView() {
        imgAvatar = findViewById(R.id.imgAvatar)
        tvUserName = findViewById(R.id.tvUserName)
        tvUserStatus = findViewById(R.id.tvUserStatus)
    }
}