import java.util.*;

    class Solution {

        public static class TreeNode {
            int value;
            TreeNode left;
            TreeNode right;

            public TreeNode(int value) {
                this.value = value;
            }

            public String toString() {
                return String.valueOf(value);
            }
        }

        public static void main(String[] args) {

            TreeNode root = createTestTree();

            LinkedList<TreeNode> outputList = new LinkedList<>();
            convertToLinkedList(root, outputList);
            System.out.println(outputList);
        }

        public static void convertToLinkedList(
                TreeNode root,
                LinkedList<TreeNode> outputList) {

            outputList.add(root);
            int iter = 0;
            TreeNode workingNode;
            while (iter < outputList.size() ) {

                workingNode = outputList.get(iter++);
                if (workingNode.left != null) {
                    outputList.add(workingNode.left);
                }
                if (workingNode.right != null) {
                    outputList.add(workingNode.right);
                }
            }
        }

        /* If you need to allocate memory for primitive array */
        public static int determineMaxNumberOfNodes(TreeNode root) {
            int level = 0;
            TreeNode workingNode = root;
            while (workingNode.left != null) {
                level++;
                workingNode = workingNode.left;
            }
            // if you need to pre-allocate the linkedList's size or even use a primitive array, use maxNumberOfNodes
            return (int) Math.pow(2, level) - 1;
        }

        public static TreeNode createTestTree() {
            TreeNode root = null;
            LinkedList<TreeNode> linkedList = new LinkedList<>();

            for (int i = 1; i < 100; i++) {
                // create node linkedList.add(node)
                TreeNode node = new TreeNode(i);
                if (root == null) {
                    root = node;
                }
                linkedList.add(node);

                // if linkedList.getFirst().left is not taken, assign node
                if (linkedList.size() > 1) {
                    if (linkedList.getFirst().left == null) {
                        linkedList.getFirst().left = node;
                        // System.out.println("assigning " + node + " to " + linkedList.getFirst() + "'s left");

                        // else take linkedList.getFirst().right if thats not taken
                    } else if (linkedList.getFirst().right == null) {
                        linkedList.getFirst().right = node;
                        // System.out.println("assigning " + node + " to " + linkedList.getFirst() + "'s right");

                        // else linkedList.removeFirst(), assign to linkedList.getFirst().left
                    } else {
                        linkedList.removeFirst();
                        if (!linkedList.getFirst().equals(node)) {
                            // System.out.println("assigning " + node + " to " + linkedList.getFirst() + "'s left");

                            linkedList.getFirst().left = node;
                        }
                    }
                }
            }
            return root;
        }
    }
