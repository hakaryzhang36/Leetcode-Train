// Leetcode 530-minimum-absolute-difference-in-bst
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
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root); 
        return min;       
    }

    public void inorder(TreeNode root) {
        // go left
        if (root.left != null) {
            inorder(root.left);
        }
        
        // visit mid
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;

        // go right
        if (root.right != null) {
            inorder(root.right);
        }
        return;
    }
}