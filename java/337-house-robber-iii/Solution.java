// Leetcode 337-house-robber-iii
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
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        int[] left = root.left != null ? robSub(root.left) : new int[]{0,0};
        int[] right = root.right != null ? robSub(root.right) : new int[]{0,0};
        int[] res = new int[2];
        // do
        res[0] = root.val + left[1] + right[1];
        // undo
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}