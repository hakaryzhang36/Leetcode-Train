// Leetcode 108-convert-sorted-array-to-binary-search-tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return reserve(nums, 0, nums.length - 1);
    }

    public TreeNode reserve(int[] nums, int front, int tail) {
        if (front > tail) {
            return null;
        }
        if (front == tail) {
            return new TreeNode(nums[front]);
        }
        // find middle number
        int mid = (front + tail) / 2;
        // root
        TreeNode root = new TreeNode(nums[mid]);
        // split nums[] and reserve
        root.left = reserve(nums, front, mid - 1);
        root.right = reserve(nums, mid + 1, tail);
        return root;
    }
}