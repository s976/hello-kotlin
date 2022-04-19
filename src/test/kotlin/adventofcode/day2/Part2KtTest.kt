package adventofcode.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part2KtTest {

    @Test
    fun isValid2() {
        val valid1 = "1-3 a: abcde"
        val notValid1 = "1-3 b: cdefg"
        val notValid2 = "2-9 c: ccccccccc"
        assert(isValid2(valid1))
        assertFalse(isValid2(notValid1))
        assertFalse(isValid2(notValid2))
    }
}