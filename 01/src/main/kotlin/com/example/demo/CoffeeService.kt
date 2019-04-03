package com.example.demo

interface CoffeeService {
    fun getCoffee(id: Int): Coffee?
    fun createCoffee(customer: Coffee)
    fun deleteCoffee(id: Int)
    fun updateCoffee(id: Int, customer: Coffee)
    fun searchCoffees(nameFilter: String): List<Coffee>
}