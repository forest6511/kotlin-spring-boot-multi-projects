package com.example.mapper

import com.example.project1.repository.category.CategoryWithSubMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CategoryMapperTest(
    @Autowired val categoryMapper: CategoryWithSubMapper
) : BaseTest() {

    @Test
    fun `select all category`() {
        val rows = categoryMapper.find()
        rows.forEach {
            println(it)
        }
        assertEquals(3, rows.size)
    }
}
