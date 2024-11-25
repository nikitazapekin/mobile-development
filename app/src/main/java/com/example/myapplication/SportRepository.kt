package com.example.myapplication

import com.example.myapplication.R

object SportRepository {
    fun getSports(): List<OlympicSport> {
        return listOf(
            OlympicSport("Футбол", R.drawable.football_logo, false, true, 1900),
            OlympicSport("Биатлон", R.drawable.biathlon_logo, true, false, 1960),
            OlympicSport("Легкая атлетика", R.drawable.athletics_logo, false, false, 1896)
            // Добавьте другие виды спорта
        )
    }
}