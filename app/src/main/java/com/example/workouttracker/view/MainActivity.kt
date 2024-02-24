package com.example.workouttracker.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workouttracker.R
import com.example.workouttracker.adapterRecyclerview.SportAdapter
import com.example.workouttracker.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var imgAvatar: ImageView
    private lateinit var tvUserName: TextView
    private lateinit var tvUserStatus: TextView
    private lateinit var rvSport: RecyclerView

    private lateinit var sportAdapter: SportAdapter

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setView()
        setupSportRv()
        observeLiveData()
    }

    private fun setupSportRv() {
        sportAdapter = SportAdapter(mainViewModel.sportList.value!!)
        rvSport.adapter = sportAdapter
        rvSport.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeLiveData() {
        // observe userInfo live data
        mainViewModel.userInfo.observe(this) { newUserInfo ->
            tvUserName.text = newUserInfo.name
            tvUserStatus.text = newUserInfo.getUserStatus()
        }

        // observe sportList live data
        // init sportList data -> get data from sport repository
        mainViewModel.sportList.observe(this) { newSportList ->
            sportAdapter = SportAdapter(newSportList)
            rvSport.adapter = sportAdapter
        }

        // observe sportListAddPosition live data
        // update data when add new sport
        mainViewModel.sportListAddPosition.observe(this) {
            sportAdapter.notifyItemInserted(0)
        }

        // observe sportListRemovePosition live data
        // update data when remove sport
        mainViewModel.sportListRemovePosition.observe(this) {newSportListRemovePosition ->
            sportAdapter.notifyItemRemoved(newSportListRemovePosition)
            sportAdapter.notifyItemRangeChanged(newSportListRemovePosition, mainViewModel.sportList.value!!.size)
        }
    }

    private fun setView() {
        imgAvatar = findViewById(R.id.imgAvatar)
        tvUserName = findViewById(R.id.tvUserName)
        tvUserStatus = findViewById(R.id.tvUserStatus)
        rvSport = findViewById(R.id.rvSport)
    }
}