package com.example.workouttracker.model

import kotlin.math.roundToInt

class User(
    var name: String,
    var dateBirth: String,
    var gender: String,
    var national: String,
    var weight: Double,
    var height: Double
) {
    fun getBMI(): Double {
        return weight / (height * height)
    }

    fun getHeightFormat(): String {
//        val intPart = height.toInt()
//        val fractionalPart = height - intPart
        val heightString = height.toString()
        return "${
            heightString.substring(
                startIndex = 0,
                endIndex = heightString.indexOf('.')
            )
        }m${
            heightString.substring(
                startIndex = heightString.indexOf('.') + 1
            )
        }"
    }

    fun getWeightFormat(): String {
        return "${weight}kg"
    }

    fun getUserStatus(): String {
        return "${getHeightFormat()} - ${getWeightFormat()}"
    }
}