package com.example.project1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@EntityScan("com.example.common.domain")
@SpringBootApplication
class Project1Application

fun main(args: Array<String>) {
	runApplication<Project1Application>(*args)
}
