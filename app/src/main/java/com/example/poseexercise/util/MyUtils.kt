package com.example.poseexercise.util

import android.util.Log

class MyUtils {

    companion object {
        fun exerciseNameToDisplay(variableName: String): String {
            return when (variableName) {
                "squats" -> "Squat"
                "pushups_down" -> "Pushup"
                "lunges" -> "Lunge"
                // Add more cases as needed
                else -> variableName // Default to the original name if not matched
            }
        }

        fun convertTimeStringToMinutes(timeString: String): Double {
            val components = timeString.split(":")
            val total: Double

            when (components.size) {
                2 -> {
                    val (minutes, seconds) = components.map { it.toDouble() }
                    total = minutes + seconds / 60
                    Log.d("total-time $minutes $seconds", total.toString())
                }

                3 -> {
                    val (hours, minutes, seconds) = components.map { it.toDouble() }
                    total = hours * 60 + minutes + seconds / 60
                    Log.d("total-time $hours $minutes $seconds", total.toString())
                }

                else -> {
                    Log.e(
                        "Invalid time format",
                        "The time string must be in 'hh:mm' or 'hh:mm:ss' format."
                    )
                    return 0.0
                }
            }
            return total
        }

        fun databaseNameToClassification(variableName: String): String {
            return when (variableName) {
                "Push up" -> "pushups_down"
                "Lunges" -> "lunges"
                "Squats" -> "squats"
                "Sit Up" -> "situp_up"
                // Add more cases as needed
                else -> variableName // Default to the original name if not matched
            }
        }
    }
}