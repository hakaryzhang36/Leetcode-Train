// Leetcode 654-maximum-binary-tree
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        // Get root
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[pos]) {
                pos = i;
            }
        }
        TreeNode root = new TreeNode(nums[pos]);

        // Create left[]
        int[] left = new int[pos];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }


        // Create right[]
        int[] right = new int[nums.length - pos - 1];
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[pos + 1 + i];
        }

        // System.out.printf("%d, %d\n", left.length, right.length);

        // Generate childs
        if (left.length > 0) {
            root.left = constructMaximumBinaryTree(left);
        }
        if (right.length > 0) {
            root.right = constructMaximumBinaryTree(right);
        }

        return root;
    }
}