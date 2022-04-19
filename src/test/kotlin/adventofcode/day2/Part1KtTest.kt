package adventofcode.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part1KtTest {

    @Test
    fun `isValid basic input`() {
        val valid1 = "1-3 a: abcde"
        val notValid = "1-3 b: cdefg"
        val valid2 = "2-9 c: ccccccccc"
        assert(isValid(valid1))
        assertFalse(isValid(notValid))
        assert(isValid(valid2))
    }
}