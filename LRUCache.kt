import java.util.*

fun main() {
    val lruCache = LRUCache(4)
    lruCache.put("1", "1a")
    lruCache.put("2", "2a")
    lruCache.put("3", "3a")
    lruCache.put("4", "4a")
    lruCache.put("5", "5a")

    println("5 ${lruCache.get("5")}")
    println("1 ${lruCache.get("1")}")
    println("2 ${lruCache.get("2")}")
    lruCache.put("6", "6a")

    println("3 ${lruCache.get("3")}")

    // outputs:
    // 5 5a
    // 1 null
    // 2 2a
    // 3 null

}

class LRUCache(val capacity: Int) {

    private val items = mutableMapOf<String,String>()
    private val addedOrder = LinkedList<String>()

    fun put(key: String, value: String) {
        if (items[key] != null) {
            addedOrder.remove(key)
        }
        items[key] = value
        addedOrder.add(key)
        if (items.size > capacity) {
            val kickout = addedOrder.removeFirst()
            items.remove(kickout)
        }
    }

    fun get(key: String) = items[key].also {
        addedOrder.remove(key)
        addedOrder.add(key)
    }
}