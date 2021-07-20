package com.example.project2.exercise.generics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MyList<E> {
    private val inside = mutableListOf<E>()
    fun add(a: E) {
        inside.add(a)
    }

    fun p() {
        inside.forEach {
            println(it)
        }
    }

    fun get(): MutableList<E> {
        return inside
    }
}

class LeanGenerics {

    @Test
    fun test1() {
        val a = MyList<Int>()
        a.add(3)
        a.add(2)
        a.p()

        val i = a.get().fold(0) { x, y -> x + y }

        assertEquals(5, i)
    }
}
