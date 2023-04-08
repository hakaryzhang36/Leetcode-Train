// Leetcode 101-symmetric-tree
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
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return isSymmetricSub(root.left, root.right);
        }
        else return true;
    }

    public boolean isSymmetricSub(TreeNode rootLeft, TreeNode rootRight) {
        if ((rootLeft == null && rootRight != null) || (rootLeft != null && rootRight == null)) {
            return false;
        }

        if (rootLeft == null && rootRight == null) {
            return true;
        }

        if (rootLeft.val == rootRight.val) {
            return isSymmetricSub(rootLeft.left, rootRight.right) && isSymmetricSub(rootLeft.right, rootRight.left);
        }
        else {
            return false;
        }

    }
}