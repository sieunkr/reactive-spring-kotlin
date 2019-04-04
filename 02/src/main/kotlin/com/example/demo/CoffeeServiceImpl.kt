package com.example.demo

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

@Component
class CoffeeServiceImpl : CoffeeService {

    companion object {
        val initialCoffees = arrayOf(Coffee(1, "latte"),
                Coffee(2, "mocha"))
    }

    val coffees = ConcurrentHashMap<Int, Coffee>(initialCoffees.associateBy(Coffee::id))


    override fun getCoffee(id: Int) = coffees[id]?.toMono() ?: Mono.empty()


    override fun searchCoffees(nameFilter: String): Flux<Coffee> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createCoffee(coffeeMono: Mono<Coffee>): Mono<Coffee> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}