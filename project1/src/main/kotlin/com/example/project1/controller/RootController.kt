package com.example.project1.controller

import com.example.project1.repository.category.CategoryWithSubRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RootController(
    val categoryWithSubRepository: CategoryWithSubRepository
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("")
    fun index(model: Model): String {
        log.info("Root is called.")

        val rows = categoryWithSubRepository.find()
        log.info("rows is $rows")

        model.addAttribute("message", "Hello Project1")
        return PathTemplate.INDEX.path
    }
}