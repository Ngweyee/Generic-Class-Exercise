package com.littlelemon.genericclassexercise


sealed class Ingredient {
    object Cheese : Ingredient()
    object Flour : Ingredient()
    object Egg : Ingredient()
    object Onion : Ingredient()
}

class Inventory<INGREDIENT : Ingredient> {

    var contents: MutableList<INGREDIENT> = mutableListOf()

    fun addIngredient(ingredient: INGREDIENT) {
        contents.add(ingredient)
    }

    fun count(): Int {
        return contents.size
    }

    companion object {
        fun <INGREDIENT : Ingredient> newInventory(): Inventory<INGREDIENT> {
            return Inventory()
        }
    }



}

fun multiplyBy2(i : Int) : Int { return i * 2 }

var numberList = listOf(1,2,3)


fun main() {

    var cheeseInventory = Inventory.newInventory<Ingredient.Onion>()
    cheeseInventory.addIngredient(Ingredient.Onion)
    cheeseInventory.addIngredient(Ingredient.Onion)
    print(cheeseInventory.count())

    println(numberList.map(::multiplyBy2))
}



