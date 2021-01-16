import java.util.*


/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
fun main() {
    example1()
    example2()
    example3()
}

private fun example1() {
    println("${Solution4().letterCombinations("2")} should be [\"a\",\"b\",\"c\"]")
}
private fun example3() {
    println("${Solution4().letterCombinations("")} should be []")

}
private fun example2() {
    println("${Solution4().letterCombinations("23")} should be [\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]")

}

class Solution4 {
    fun letterCombinations(digits: String): List<String> {
        val alphaMap = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )
        val retList = mutableListOf<String>()
        digits.toCharArray().forEach { digit ->
            if (retList.isEmpty()) {
                retList.addAll(alphaMap[digit]!!.toCharArray().map { it.toString() })
            } else {
                val newRetList = mutableListOf<String>()
                alphaMap[digit]!!.toCharArray().forEach { alphaChar ->
                    retList.forEachIndexed { index, retString ->
                        newRetList.add ( "$retString$alphaChar")
                    }
                }
                retList.clear()
                retList.addAll(newRetList)
            }

        }

        return retList
    }
}