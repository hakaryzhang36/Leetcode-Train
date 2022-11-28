// Leetcode 437-path-sum-iii
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
    int targetSum;
    List<Long> pathSum = new ArrayList<>();
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        traverse(root);
        return count;
    }

    private void traverse(TreeNode root) {
        // update path sum
        for (int i = 0; i < pathSum.size(); i++) {
            pathSum.set(i, pathSum.get(i) + root.val);
            if (pathSum.get(i) == targetSum) {
                count++;
            }
        }
        // add new path sum
        pathSum.add(new Long(root.val));
        if (root.val == targetSum) {
            count++;
        }
        // traverse
        if (root.left != null) {
            traverse(root.left);
        }
        if (root.right != null) {
            traverse(root.right);
        }
        // undo update path sum
        pathSum.remove(pathSum.size() - 1);
        for (int i = 0; i < pathSum.size(); i++) {
            pathSum.set(i, pathSum.get(i) - root.val);
        }
        return;
    }
}