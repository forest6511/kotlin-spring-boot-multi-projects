package com.example.mapper

import com.example.project1.Project1Application
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest(classes = [Project1Application::class])
@ActiveProfiles(profiles = ["test"])
class BaseTest {
}