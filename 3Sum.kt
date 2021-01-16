fun main() {
    val problem = intArrayOf(0,0,0)
//    val problem = intArrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)

    println(Solution().threeSum(problem))
}

class Solution {
    fun threeSum(numsIn: IntArray): List<List<Int>> {
        val nums =  numsIn.sorted()
        var returnIndices = mutableListOf<Triple<Int, Int, Int>>()
        if (nums.firstOrNull() == nums.lastOrNull() &&
            nums.firstOrNull() == 0 &&
            nums.size >= 3
        ) {
            return listOf(listOf(0,0,0))
        }
        for (i in 1 until nums.size - 1) {
            var a = 0
            var b = i
            var c = nums.size - 1
            while (true) {
                val sum = nums[a] + nums[b] + nums[c]
                when {
                    sum > 0 -> c--
                    sum < 0 -> a++
                    sum == 0 -> {
                        returnIndices.add(Triple(a, b, c))
                        c--
                        a++
                    }
                }
                if (a == b || c == b) {
                    break
                }
            }
        }

        return returnIndices.map {
            listOf(nums[it.first], nums[it.second], nums[it.third]).sorted()
        }.distinct()

    }


}
