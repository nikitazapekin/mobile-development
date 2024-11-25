package com.example.myapplication

data class OlympicSport(
    val name: String,
    val logo: Int, // Ресурс изображения
    val isWinter: Boolean,
    val isTeam: Boolean,
    val yearRecognized: Int
)
