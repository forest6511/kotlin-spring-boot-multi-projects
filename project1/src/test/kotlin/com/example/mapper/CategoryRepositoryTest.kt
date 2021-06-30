package com.example.mapper

import com.example.project1.repository.category.CategoryWithSubRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


class CategoryRepositoryTest(
    @Autowired val categoryWithSubRepository: CategoryWithSubRepository
) : BaseTest() {

    @Test
    fun `select all category`() {
        val rows = categoryWithSubRepository.find()
        rows.forEach {
            println(it)
        }
        assertEquals(3, rows.size)
    }
}
