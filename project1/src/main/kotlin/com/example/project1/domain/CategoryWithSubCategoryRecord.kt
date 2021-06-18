package com.example.project1.domain

import com.example.project1.Data
import com.example.project1.domain.base.SubCategoryRecord

@Data
data class CategoryWithSubCategoryRecord(
    val id: Long,
    val name: String,
    val subCategories: MutableList<SubCategoryRecord>
)
