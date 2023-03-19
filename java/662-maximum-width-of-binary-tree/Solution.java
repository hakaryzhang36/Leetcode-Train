// Leetcode 662-maximum-width-of-binary-tree
// mark
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long max = 1;
    Map<Integer, Long> leftWidthOfLevel = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findLeftNode(root, 0, 0);
        return (int)max;
    }

    private void findLeftNode(TreeNode node, long leftWidth, int depth) {
        if (node == null) {
            return;
        }
        if (leftWidthOfLevel.getOrDefault(depth, (long)-1) == (long)-1) {
            // 找到左端点
            leftWidthOfLevel.put(depth, leftWidth);
        }
        else {
            // 找到右端点
            max = Math.max(max, leftWidth - leftWidthOfLevel.get(depth) + 1);
        }
        // 先找左子树，保证先找到左端点后才会找到右端点
        findLeftNode(node.left, leftWidth*2, depth+1);
        findLeftNode(node.right, leftWidth*2+1, depth+1);
    }
}