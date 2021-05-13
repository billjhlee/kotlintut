package com.example.tut

import com.example.tut.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class TutApplication {

    @GetMapping
    fun hi(): Person {
        return Person(0, "hello")
    }
}

fun main(args: Array<String>) {
    runApplication<TutApplication>(*args)
}
