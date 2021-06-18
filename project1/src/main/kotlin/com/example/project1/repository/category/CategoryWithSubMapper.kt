package com.example.project1.repository.category

import com.example.project1.domain.CategoryWithSubCategoryRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CategoryWithSubMapper {
    fun find(): List<CategoryWithSubCategoryRecord>
}