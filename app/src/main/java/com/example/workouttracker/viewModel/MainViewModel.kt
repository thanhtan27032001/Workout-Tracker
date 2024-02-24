package com.example.workouttracker.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workouttracker.model.Sport
import com.example.workouttracker.model.User
import com.example.workouttracker.repository.SportRepository
import com.example.workouttracker.repository.UserRepository

class MainViewModel: ViewModel() {
    var userInfo = MutableLiveData<User>().apply {
        value = UserRepository.getUserInfo()
    }

    var sportList = MutableLiveData<ArrayList<Sport>>().apply { value = arrayListOf() }
    var sportListAddPosition = MutableLiveData<Int>().apply { value = 0 }
    var sportListRemovePosition = MutableLiveData<Int>().apply { value = 0 }

    init {
        fetchSportList()
    }

    fun fetchSportList() {
        sportList.value = SportRepository.fetchSportList()
    }
}