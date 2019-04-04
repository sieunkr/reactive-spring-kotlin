package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeController {
    @Autowired
    private lateinit var coffeeService: CoffeeService

    @GetMapping(value = ["/coffees/{id}"])
    fun getCustomer(@PathVariable id: Int) =
            ResponseEntity(coffeeService.getCoffee(id), HttpStatus.OK)

}