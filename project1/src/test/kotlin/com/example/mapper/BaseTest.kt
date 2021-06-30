package com.example.mapper

import com.example.project1.Project1Application
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest(
    classes = [Project1Application::class],
    properties = ["spring.profiles.active:test"]
) class BaseTest {
}