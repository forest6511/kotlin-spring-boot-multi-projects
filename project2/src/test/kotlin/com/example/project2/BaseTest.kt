package com.example.project2

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@EnableR2dbcRepositories
@AutoConfigureWebTestClient
@SpringBootTest(properties = ["spring.profiles.active:test"], webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseTest {
}
