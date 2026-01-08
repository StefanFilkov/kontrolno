package com.example.myapplication

import androidx.annotation.DrawableRes

data class PizzaType(
    val name: String,
    val description: String,
    @DrawableRes val imageRes: Int
)

data class PizzaOrder(
    val id: Long,
    val pizza: PizzaType
)
