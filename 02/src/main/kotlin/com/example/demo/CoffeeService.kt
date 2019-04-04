package com.example.demo

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CoffeeService {

    fun getCoffee(id: Int): Mono<Coffee>
    fun searchCoffees(nameFilter: String): Flux<Coffee>
    fun createCoffee(coffeeMono: Mono<Coffee>): Mono<Coffee>
}