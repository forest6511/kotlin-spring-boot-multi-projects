package com.example.project2.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class RootController {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("")
    fun index(model: Model): String {
        log.info("Root is called.")

        model.addAttribute("message", "Hello Project2")
        return PathTemplate.INDEX.path
    }
}