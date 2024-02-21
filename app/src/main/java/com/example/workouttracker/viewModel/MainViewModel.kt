package com.example.workouttracker.viewModel

import androidx.databinding.BaseObservable
import com.example.workouttracker.model.User

class MainViewModel(
    var userInfo: User
): BaseObservable() {
}