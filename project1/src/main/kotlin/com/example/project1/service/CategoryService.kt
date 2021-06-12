package com.example.project1.service

import com.example.common.domain.CategoryEntity
import com.example.project1.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {
    fun findAll() = categoryRepository.findAll()

    fun findOne(id: Long) = categoryRepository.findById(id).orElse(null)

    fun save(category: CategoryEntity) =categoryRepository.save(category)

    fun delete(id: Long) = categoryRepository.deleteById(id)
}