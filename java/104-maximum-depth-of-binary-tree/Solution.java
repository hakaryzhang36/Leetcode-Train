// Leetcode 104-maximum-depth-of-binary-tree
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
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        for(;!q.isEmpty();) {
            res++;
            Deque<TreeNode> temp = new ArrayDeque<>();
            for(;!q.isEmpty();) {
                TreeNode node = q.pollFirst();
                if (node.left != null) {
                    temp.addLast(node.left);
                }
                if (node.right != null) {
                    temp.addLast(node.right);
                }
            }
            q = temp;
        }
        return res;
    }
}