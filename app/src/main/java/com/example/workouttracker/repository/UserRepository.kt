package com.example.workouttracker.repository

import com.example.workouttracker.model.User

class UserRepository {
    companion object {
        fun getUserInfo(): User {
            return User(
                name = "Nguyễn Thành Tân",
                dateBirth = "",
                gender = "Male",
                national = "",
                weight = 66.0,
                height = 1.71
            )
        }
    }
}