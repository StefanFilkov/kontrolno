package com.example.myapplication

object FakePizzas {
    // If you don't have images yet, you can temporarily point all of them to the same drawable.
    // Later replace with your real drawables (e.g. R.drawable.margherita, etc.)
    val pizzas = listOf(
        PizzaType("Margherita", "Tomato sauce, mozzarella, basil.", R.drawable.pizza_1),
        PizzaType("Pepperoni", "Mozzarella, pepperoni, tomato sauce.", R.drawable.pizza_2),
        PizzaType("Hawaiian", "Ham, pineapple, mozzarella.", R.drawable.pizza_3),
        PizzaType("Vegetarian", "Bell peppers, olives, mushrooms, onion.", R.drawable.pizza_4),
        PizzaType("BBQ Chicken", "BBQ sauce, chicken, red onion, cheese.", R.drawable.pizza_5),
        PizzaType("Four Cheese", "Mozzarella, cheddar, gorgonzola, parmesan.", R.drawable.pizza_6)
    )
}