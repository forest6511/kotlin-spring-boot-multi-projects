package com.example.project1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan("com.example.common.domain")
@EnableJpaRepositories("com.example.project1.repository")
@SpringBootApplication
class Project1Application

fun main(args: Array<String>) {
	runApplication<Project1Application>(*args)
}
