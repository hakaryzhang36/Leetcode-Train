// Leetcode 1026-maximum-difference-between-node-and-ancestor
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
    class Pair {
        int max;
        int min;
    }
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        sub(root);
        return res;
    }

    public Pair sub(TreeNode root) {
        if (root == null) {
            return null;
        }
        Pair lp = sub(root.left);
        Pair rp = sub(root.right);

        Pair resPair = new Pair();
        resPair.max = root.val;
        resPair.min = root.val;

        if (lp != null) {
            res = Math.max(res, Math.max(Math.abs(root.val-lp.max), Math.abs(root.val-lp.min)));
            resPair.max = Math.max(resPair.max, lp.max);
            resPair.min = Math.min(resPair.min, lp.min);
        }
        if (rp != null) {
            res = Math.max(res, Math.max(Math.abs(root.val-rp.max), Math.abs(root.val-rp.min)));
            resPair.max = Math.max(resPair.max, rp.max);
            resPair.min = Math.min(resPair.min, rp.min);
        }
        return resPair;
    }
}