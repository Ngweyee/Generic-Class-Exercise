package com.littlelemon.genericclassexercise


data class DiscountCoupon(
    val percentage: Int,
    val minimumOrderAmount: Int
)

val orderAmount = 134

val discountCouponList = listOf(

    DiscountCoupon(10, 150),

    DiscountCoupon(5, 75),

    DiscountCoupon(8, 100),

    DiscountCoupon(6, 90)

)

val discountValuesList = discountCouponList.map { discountCoupon ->

    if (orderAmount >= discountCoupon.minimumOrderAmount) {
        orderAmount * discountCoupon.percentage / 100
    } else {
        0
    }
}

data class StockIngredient(
    val name: String,
    val stockUnits: Int
)

val stockIngredientList = listOf(
    StockIngredient("Olive Oil", 7),
    StockIngredient("Wheat", 3),
    StockIngredient("Soda", 10),
    StockIngredient("Egg", 0),
    StockIngredient("Yeast", 2)
)


val ingredientsToRefill = stockIngredientList.filter { ingredient ->
    ingredient.stockUnits < 5
}

data class OrderItem(
    val name: String,
    val amount: Int,
    val quantity: Int
)

val orderItemList = listOf(
    OrderItem("Burger", 6, 2),
    OrderItem("Fries", 2, 1),
    OrderItem("Soda", 3, 3)
)

var totalAmount = orderItemList.fold(0) { totalOrderAmount, orderItem ->
    totalOrderAmount + (orderItem.amount * orderItem.quantity)
}

data class Order(
    val orderId: Int,
    val month: String,
    val amount: Int
)

val orderList = listOf(
    Order(1, "August", 40),
    Order(2, "August", 27),
    Order(3, "September", 44),
    Order(4, "September", 57),
    Order(5, "October", 38),
)

var aggregateSalesTaxForSeptember = orderList.filter { order ->

    order.month == "August"

}.map { order ->

    7.5 / 100 * order.amount
}.fold(0.0) { totalTaxAmount, it ->
    totalTaxAmount + it
}

fun main() {
    println("Discount Value List $discountValuesList")
    println("Ingredients To Refill $ingredientsToRefill")
    println(totalAmount)
    print("Aggredated Sales Amount for September ${aggregateSalesTaxForSeptember}")

    val number = 3
    var output = 2
    repeat(5) { index ->
        output += (index * number)
    }
    println(output)
}
