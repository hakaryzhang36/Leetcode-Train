// Leetcode 114-flatten-binary-tree-to-linked-list
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
    TreeNode node = new TreeNode();
    public void flatten(TreeNode root) {
        node.right = root;
        preTravel(root);
    }

    private void preTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        // System.out.println(root.val);
        TreeNode rightNode = root.right;
        TreeNode leftNode = root.left;
        node.right = root;
        node.left = null;
        node = node.right;
        preTravel(leftNode);
        preTravel(rightNode);
    }
}