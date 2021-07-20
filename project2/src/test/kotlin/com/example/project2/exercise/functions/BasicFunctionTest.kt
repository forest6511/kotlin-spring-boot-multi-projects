package com.example.project2.exercise.functions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicFunctionTest {

    private fun aFunction(a: String, b: Int): String {
        return "$a-$b"
    }

    val anonymousFuncDouble = { i: Int -> i * 2 }
    val anonymousFuncPlus = { x: Int, y: Int -> x + y }
    val anonymousFuncEquals: (Int, Int) -> Boolean = { x: Int, y: Int -> x == y }

    @Test
    fun `Basic #1`() {
        assertEquals("Test-3", aFunction("Test", 3))
        assertEquals(6, anonymousFuncDouble(3))
        assertEquals(5, anonymousFuncPlus(2,3))
        assertEquals(false, anonymousFuncEquals(5,3))
        assertEquals(true, anonymousFuncEquals(5,5))
    }
}
