package org.example.persistent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersistentApplication

fun main(args: Array<String>) {
    runApplication<PersistentApplication>(*args)
}
