package com.example.mapper

import com.example.project1.Project1Application
import com.example.project1.repository.category.CategoryWithSubRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional


@Transactional
@SpringBootTest(classes = [Project1Application::class])
class CategoryRepositoryTest(
    @Autowired val categoryWithSubRepository: CategoryWithSubRepository
) {

    @Test
    fun `select all category`() {
        val rows = categoryWithSubRepository.find()
        rows.forEach {
            println(it)
        }
        assertEquals(3, rows.size)
    }
}
