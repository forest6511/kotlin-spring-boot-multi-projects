package com.example.project1.repository.category

import com.example.project1.domain.CategoryWithSubCategoryRecord
import org.springframework.stereotype.Repository

@Repository
class CategoryWithSubRepository(
    val categoryWithSubMapper: CategoryWithSubMapper
) {
    fun find(): List<CategoryWithSubCategoryRecord> {
        return categoryWithSubMapper.find()
    }
}