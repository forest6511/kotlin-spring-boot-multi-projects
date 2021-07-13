package com.example.project2.exercise

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LearnZipUnZipTest {
    @Test
    fun `Try it out - Basic zip`() {
        val firstArray = intArrayOf(1, 2, 3, 4, 5)
        val secondArray = arrayOf("one", "two", "three", "four", "five")

        // [(1, one), (2, two), (3, three), (4, four), (5, five)]
        println("#1 ${firstArray.zip((secondArray))}")

        val testType: List<Pair<Int, String>> = firstArray.zip((secondArray))
        // [(1, one), (2, two), (3, three), (4, four), (5, five)]
        println("$2 $testType")


        /*
         * zip just takes short length array. return List of pair.
         */
        val thirdArray = secondArray.take(3)
        // [one, two, three]
        println("#3.1 $thirdArray")
        // [(1, one), (2, two), (3, three)]
        println("#3 ${firstArray.zip((thirdArray))}")

        assertEquals(3, firstArray.zip((thirdArray)).size)

        val fourthArray = firstArray.take(3)
        // [1, 2, 3]
        println("#4.1 $fourthArray")
        // [(1, one), (2, two), (3, three)]
        println("#4 ${fourthArray.zip((secondArray))}")

        assertEquals(3, fourthArray.zip((secondArray)).size)

    }

    data class Customer(
        val name: String,
        val age: Int
    )

    data class Company(
        val name: String,
        val country: String
    )

    data class Pearson(
        val customer: Customer,
        val company: Company
    )

    @Test
    fun `Try it out - Object zip`() {
        val customers = listOf(
            Customer("Tom", 33),
            Customer("Mike", 56),
            Customer("Peter", 77),
        )

        val companies = listOf(
            Company("Sony", "JP"),
            Company("Honda", "JP"),
            Company("Apple", "USA")
        )

        val persons: List<Pearson> = customers.zip(
            companies
        ) // transform
        { customer, company ->
            Pearson(Customer(customer.name, customer.age), Company(company.name, company.country))
        }

        println("#5 $persons")

        persons.filter { it.customer.age > 50 }.forEach {
            println("#6 $it")
        }
    }
}
