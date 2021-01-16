import java.util.*

fun main() {
    example1()
    example2()
    example3()
}

private fun example1() {
    val grid = listOf(
        listOf('1', '1', '0', '0', '0'),
        listOf('1', '1', '0', '0', '0'),
        listOf('0', '0', '1', '0', '0'),
        listOf('0', '0', '0', '1', '1')
    ).map {
        it.toCharArray()
    }.toTypedArray()
    
    // [listOf('1','0','1','1','1'),
    //  listOf('1','0','1','0','1'),
    //  listOf('1','1','1','0','1')]

    println("${NumberOfIslands().numIslands(grid)} should be 3")
}
private fun example3() {
    val grid = listOf(
        listOf('1', '0', '1', '1', '1'),
        listOf('1', '0', '1', '0', '1'),
        listOf('1', '1', '1', '0', '1')
    ).map {
        it.toCharArray()
    }.toTypedArray()

    println("${NumberOfIslands().numIslands(grid)} should be 1")
}
private fun example2() {
    val grid = listOf(
        listOf('1', '1', '1', ),
        listOf('0', '1', '0', ),
        listOf('1', '1', '1', )
    ).map {
        it.toCharArray()
    }.toTypedArray()

    println("${NumberOfIslands().numIslands(grid)} should be 1")
}

class NumberOfIslands {
    // Stack of coords,
    // list of islands
    // each island has a stack
    // add neighbors to stack
    fun numIslands(grid: Array<CharArray>): Int {

        val islands = mutableListOf<MutableList<String>>()

        grid.forEachIndexed { y, chars ->
            chars.forEachIndexed { x, c ->
                if (c == '1') {
                    var foundIsland: MutableList<String>? = null
                    // west
                    if (x != 0) {
                        val island = islands.firstOrNull { it.contains("${x-1}:$y") }
                        if (island != null) {
                            island.add("$x:$y")
                            foundIsland = island
                        }
                    }

                    // north
                    if (foundIsland == null && y != 0) {
                        val island = islands.firstOrNull { it.contains("${x}:${y-1}") }
                        if (island != null) {
                            island.add("$x:$y")
                            foundIsland = island
                        }
                    } else if (foundIsland != null && y != 0) {
                        val island2 = islands.firstOrNull { it.contains("${x}:${y-1}") }
                        if (island2 != null && foundIsland != island2) {
                            // merge 2 islands
                            foundIsland.addAll(island2)
                            islands.remove(island2)

                            foundIsland.add("$x:$y")
                        }
                    }

                    if (foundIsland == null) {
                        foundIsland = mutableListOf("$x:$y")
                        islands.add(foundIsland)
                    }

                }
            }
        }

        return islands.count()
    }



}