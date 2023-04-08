// Leetcode 94-binary-tree-inorder-traversal
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
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalSub(root);
        return res;
    }

    public void inorderTraversalSub(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalSub(root.left);
        res.add(root.val);
        inorderTraversalSub(root.right);
    }
}