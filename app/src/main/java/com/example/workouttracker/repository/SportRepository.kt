package com.example.workouttracker.repository

import com.example.workouttracker.model.Sport

class SportRepository {
    companion object {
        fun fetchSportList(): ArrayList<Sport> {
            return arrayListOf(
                Sport(0, "Đạp xe", "", false),
                Sport(1, "Chạy bộ", "", false),
                Sport(2, "Hít đất", "", false),
                Sport(3, "Nâng tạ", "", false),
                Sport(4, "Nhảy dây", "", false),
            )
        }
    }
}