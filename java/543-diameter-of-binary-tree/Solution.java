// Leetcode 543-diameter-of-binary-tree
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
    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        postorder(root);
        return maxLength;
    }

    private int postorder(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int dl = 0, dr = 0;
        if (root.left != null) {
            dl = postorder(root.left);
        }
        if (root.right != null) {
            dr = postorder(root.right);
        }
        
        maxLength = Math.max(dr+dl, maxLength);
        return Math.max(dr, dl) + 1;
    }
}