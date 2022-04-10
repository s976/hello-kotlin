package adventofcode

import adventofcode.day1.twoOf
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle1KtTest {
    private fun listToNumbersMap(list: List<Int>) : Map<Int, Int> {
        return list.groupingBy { it }.eachCount()
    }

    @Test
    fun `find two numbers`() {
        val inputList = listOf(1, 2 ,3, 4)
        val total = 7
        assertEquals(listOf(3, 4), twoOf(total, listToNumbersMap(inputList)))
    }

    @Test
    fun `find two numbers with duplicates`() {
        val inputList = listOf(1, 2 ,3, 4, 3, 4)
        val total = 8
        assertEquals(listOf(4, 4), twoOf(total, listToNumbersMap(inputList)))
    }

    @Test
    fun `do not find two numbers`() {
        val inputList = listOf(1, 2 ,3, 4)
        println(listToNumbersMap(inputList))
        val total = 8
        assertEquals(null, twoOf(total, listToNumbersMap(inputList)))
    }

}