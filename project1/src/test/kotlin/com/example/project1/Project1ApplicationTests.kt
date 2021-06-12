package com.example.project1

import com.example.common.domain.CategoryEntity
import com.example.project1.service.CategoryService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class Project1ApplicationTests(@Autowired val service: CategoryService) {

    @Test
    fun contextLoads() {
        val category = CategoryEntity(
            name = "Test",
            orderBy = 1
        )
        service.save(category)

        println(category)

        println(service.findAll())


        Thread.sleep(1000 * 10)

        category.name = "Test1"
        service.save(category)

        println(service.findAll())


    }

}
