package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CoffeeController {

    @Autowired
    private lateinit var coffeeservice: CoffeeService

    /*
    @RequestMapping(value = ["/coffee"], method = [RequestMethod.GET])
    fun getCoffee() = Coffee(1, "mocha")
    */

    @GetMapping(value = ["/coffees/{id}"])
    fun getCoffee(@PathVariable id: Int): ResponseEntity<Any> {
        val coffee = coffeeservice.getCoffee(id)

        return if (coffee != null)
            ResponseEntity(coffee, HttpStatus.OK)
        else
            ResponseEntity("error", HttpStatus.NOT_FOUND)
    }
    

}