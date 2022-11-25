// Leetcode 98-validate-binary-search-tree
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST_sub(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBST_sub(TreeNode root, long max, long min) {
        boolean pl = true, pr = true;
        if (root.left != null) {
            if (root.left.val >= root.val || root.left.val <= min) {
                return false;
            }
            else {
                pl = isValidBST_sub(root.left, root.val, min);
            }
        }
        if (root.right != null) {
            if (root.right.val <= root.val || root.right.val >= max) {
                return false;
            }
            else {
                pr = isValidBST_sub(root.right, max, root.val);
            }
        }
        
        if (pl && pr) {
            return true;
        }
        else {
            return false;
        }
    }
}