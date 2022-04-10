/*
 * Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.

Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

For example, suppose your expense report contained the following:

1721
979
366
299
675
1456
In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.

Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?
 */

package adventofcode.day1

import java.io.File

fun puzzle1(): Int? {
    val total = 2020
    val numbersMap = numbersMapFromFile("src/main/resources/puzzle1.txt")

    return when (val res = twoOf(total, numbersMap)) {
        is List<Int> -> res[0] * res[1]
        else -> null
    }
}


fun numbersMapFromFile(fileName: String) : Map<Int, Int> {
    return File(fileName)
        .readLines()
        .map { it.trim() }
        .mapNotNull { it.toIntOrNull() }
        .groupingBy { it }
        .eachCount()
}

fun twoOf(sum: Int, numbersMap: Map<Int, Int>) : List<Int>? {
    val res = numbersMap.asIterable().find {
        return@find when (it.key*2) {
            sum -> it.value > 1 // treat 1010 + 1010 = 2020 as edge case
            else -> numbersMap.containsKey(sum - it.key)
        }
    }

    return when (res) {
        null -> null
        else -> listOf(res.key, sum - res.key)
    }
}