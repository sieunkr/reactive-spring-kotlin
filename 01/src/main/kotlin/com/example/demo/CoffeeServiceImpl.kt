package com.example.demo

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class CoffeeServiceImpl : CoffeeService {
    companion object {
        val initialCoffees = arrayOf(Coffee(1, "mocha"),
                Coffee(2, "latte"),
                Coffee(3, "americano"))
    }

    val coffees = ConcurrentHashMap<Int, Coffee>(initialCoffees.associateBy(Coffee::id))

    override fun getCoffee(id: Int) = coffees[id]

    override fun createCoffee(coffee: Coffee) {
        coffees[coffee.id] = coffee
    }

    override fun deleteCoffee(id: Int) {
        coffees.remove(id)
    }

    override fun updateCoffee(id: Int, coffee: Coffee) {
        deleteCoffee(id)
        createCoffee(coffee)
    }

    override fun searchCoffees(nameFilter: String): List<Coffee> =
        coffees.filter {
            it.value.name.contains(nameFilter, true)
        }.map(Map.Entry<Int, Coffee>::value).toList()

}