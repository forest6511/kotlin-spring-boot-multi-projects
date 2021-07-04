package com.example.project2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@EnableR2dbcRepositories
@SpringBootApplication
@ConfigurationPropertiesScan
class Project2Application

fun main(args: Array<String>) {
    runApplication<Project2Application>(*args)
}
