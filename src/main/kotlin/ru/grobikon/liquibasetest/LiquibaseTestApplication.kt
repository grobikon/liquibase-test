package ru.grobikon.liquibasetest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LiquibaseTestApplication

fun main(args: Array<String>) {
    runApplication<LiquibaseTestApplication>(*args)
}
