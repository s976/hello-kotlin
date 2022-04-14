/*
For example, suppose you have the following list:

1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
Each line gives the password policy and then the password. The password policy indicates the lowest and highest number
 of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password must
  contain a at least 1 time and at most 3 times.

In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b,
 but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the
  limits of their respective policies.

How many passwords are valid according to their policies?
 */

package adventofcode.day2

import java.io.File

val pattern = Regex("""(\d+)-(\d+)\s(\w):\s(\w+)""")

fun isValid(encodedStr: String): Boolean {
    val match = pattern.find(encodedStr)
    if (match != null) {
        val (minAsStr, maxAsStr, charAsStr, string) = match.destructured
        val char = charAsStr[0]
        val min = minAsStr.toInt()
        val max = maxAsStr.toInt()
        val count = string.count {it == char}
        return count in min..max
    } else {
        throw IllegalArgumentException("Invalid encoded string: $encodedStr")
    }
}


fun day2Puzzle(): Int {
    return File("src/main/kotlin/adventofcode/day2/input.txt")
        .readLines()
        .count { isValid(it) }
}