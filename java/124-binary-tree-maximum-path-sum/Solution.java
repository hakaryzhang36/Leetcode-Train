// Leetcode 124-binary-tree-maximum-path-sum
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
    int max;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = root.val;
        postorder(root);
        return max;
    }

    private int postorder(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int maxInLeft = postorder(root.left);
        int maxInRight = postorder(root.right);
        int maxWithNode = root.val + Math.max(0, maxInLeft) + Math.max(0, maxInRight);

        // compare and get the max on this node
        int currentMax = Math.max(maxWithNode, maxInLeft);
        currentMax = Math.max(currentMax, maxInRight);
        max = Math.max(max, currentMax);
        
        return root.val + Math.max(Math.max(0, maxInLeft), Math.max(0, maxInRight)); 
    }
}