package com.example.demo

interface CoffeeService {
    fun getCoffee(id: Int): Coffee?
    fun createCoffee(coffee: Coffee)
    fun deleteCoffee(id: Int)
    fun updateCoffee(id: Int, coffee: Coffee)
    fun searchCoffees(nameFilter: String): List<Coffee>
}