package com.littlelemon.genericclassexercise

import com.littlelemon.genericclassexercise.cookies
import kotlin.random.Random

fun main() {

    var maximumDiscountValue: Int = 0
    repeat(3) { index ->

        var discount = Random.nextInt(10)

        if (discount > maximumDiscountValue) {
            maximumDiscountValue = discount
        }
        println("Attempt at ${index + 1}: $discount")

    }
    print("Maximum Discount Value $maximumDiscountValue")

    cookies.forEach {
        println("Menu item: ${it.name}")
    }

    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }

    print("Full menu:")
    fullMenu.forEach {
        println(it)
    }

    val softBakedMenu = cookies.filter {
        it.softBaked
    }

    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    val groupedMenu = cookies.groupBy { it.softBaked }

    val softBakedGroupedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    println("Grouped Soft cookies:")
    softBakedGroupedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    val totalPrice = cookies.fold(0.0) { total, cookie ->

        total + cookie.price


    }

    println("Total price: $${totalPrice}")

    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }

    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }

}

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)





