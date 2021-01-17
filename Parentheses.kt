import java.util.*


/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
fun main() {
    example1()
    example2()
    example3()
}

private fun example1() {
    println("${Parentheses().generateParenthesis(1)} 1 should be [\"()\"]")
}

private fun example3() {
    // ["(((())))","((()))()","()((()))","((())())","(())()()","()(())()","(()(()))","()()(())","((()()))","(()())()","()(()())","(()()())","()()()()"]
    // ["(((())))","((()))()","()((()))","((())())","(())()()","()(())()","(()(()))","()()(())","((()()))","(()())()","()(()())","(()()())","(())(())","()()()()"]
    println("${Parentheses().generateParenthesis(4)} should be [\"(((())))\",\"((()))()\",\"()((()))\",\"((())())\",\"(())()()\",\"()(())()\",\"(()(()))\",\"()()(())\",\"((()()))\",\"(()())()\",\"()(()())\",\"(()()())\",\"(())(())\",\"()()()()\"]")

}

private fun example2() {
    println("${Parentheses().generateParenthesis(3)} 3 should be [\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]")

}

class Parentheses {
    fun generateParenthesis(n: Int): List<String> {
        val retList = mutableListOf<String>()

        for (i in 0 until (n * 2)) {

            if (retList.isEmpty()) {
                retList.add("(")
            } else {
                var newRetList = mutableListOf<String>()
                retList.forEach {
                    var added = false
                    if (it.count { it == '(' } < n) {
                        newRetList.add("$it(")
                    }

                    if (it.count { it == ')' } < it.count { it == '(' }) {
                        newRetList.add("$it)")
                    }
                }
                retList.clear()
                retList.addAll(newRetList)

            }
        }

        return retList.distinct()
    }
}