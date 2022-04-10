/*
--- Part Two ---
The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.

In your expense report, what is the product of the three entries that sum to 2020?
 */

package adventofcode.day1

fun puzzle2(): Int? {
    val total = 2020
    val numbersMap = numbersMapFromFile("src/main/resources/puzzle1.txt")
    return when (val res = threeOf(total, numbersMap)) {
        is List<Int> -> res.reduce { acc, i -> acc * i }
        else -> null
    }
}

fun threeOf(sum: Int, numbersMap: Map<Int, Int>) : List<Int>? {
    numbersMap.asIterable().forEach {
        val subSum = sum - it.key
        val subMap = numbersMap + (it.key to (it.value - 1))
        val subRes = twoOf(subSum, subMap)
        if (subRes != null) {
            return listOf(it.key) + subRes
        }
    }

    return null
}
