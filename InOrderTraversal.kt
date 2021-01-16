
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class InOrderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }

        val mutableList = mutableListOf<Int>()
        val mutableTreeList = mutableListOf<Pair<TreeNode, Boolean>>()
        mutableTreeList.add(root to false)

        while (mutableTreeList.isNotEmpty()) {
            val entry = mutableTreeList.removeLast()
            val isVisited = entry.second
            val node = entry.first

            if (isVisited) {
                mutableList.add(node.`val`)
            } else {
                node.right?.let {mutableTreeList.add(it to false)}
                node.let {mutableTreeList.add(it to true)}
                node.left?.let {mutableTreeList.add(it to false)}
            }
        }

        return mutableList.toList()
    }
}