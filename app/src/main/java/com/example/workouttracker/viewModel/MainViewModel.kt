package com.example.workouttracker.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workouttracker.model.User
import com.example.workouttracker.repository.UserRepository

class MainViewModel: ViewModel() {
    var userInfo = MutableLiveData<User>().apply {
        value = UserRepository.getUserInfo()
    }
}