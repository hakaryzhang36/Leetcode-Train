// Leetcode 450-delete-node-in-a-bst
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        // delect ROOT
        if (root.val == key) {
            root = delete(root);
        }
        // root is not the target, keep root as return node.
        TreeNode res = root;
        // find the deleted node and delete it.
        // if it not existed, nothing change.
        while (root != null) {
            if (key < root.val) {
                if (root.left != null && root.left.val == key) {
                    root.left = delete(root.left);
                    break;
                }
                root = root.left;
            }
            else {
                if (root.right != null && root.right.val == key) {
                    root.right = delete(root.right);
                    break;
                }
                root = root.right;
            }
        }
        return res;
    }

    public TreeNode delete(TreeNode target) {
        // target has no child
        if (target.left == null && target.right == null) {
            return null;
        }
        TreeNode newRoot = null;
        // if left tree existed, rebuild the tree
        if (target.left != null) {
            // left father will be the new root.
            newRoot = target.left;
            // find the max value node in left tree
            TreeNode max = newRoot;
            while (max.right != null) {
                max = max.right;
            }
            // move the original root's right tree to max's right
            target.left = null;
            max.right = target.right;
        }
        // if right tree existed, rebuild the tree
        else if (target.right != null) {
            // right father will be the new root.
            newRoot = target.right;
            // find the min value node in right tree
            TreeNode min = newRoot;
            while (min.left != null) {
                min = min.left;
            }
            // move the original root's left tree to min's left
            target.right = null;
            min.left = target.left;
        }
        return newRoot;
    }
}