package com.example.project2.exercise.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class Exercise01 {

    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun `Try it out - Basic`() {
        runBlocking { // this: CoroutineScope
            launch { // launch a new coroutine and continue
                delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
                // [Test worker @coroutine#2]
                log.debug("World!") // print after delay
            }
            // [Test worker @coroutine#1]
            log.debug("Hello")
        }
    }
}