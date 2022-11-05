// Leetcode 538-convert-bst-to-greater-tree
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
    int total = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root, 0);
        return root;
    }
    
    public int traverse(TreeNode root, int total) {
        if (root == null) {
            return total;
        }
        total = traverse(root.right, total);
        root.val += total;
        return traverse(root.left, root.val);
    }
}