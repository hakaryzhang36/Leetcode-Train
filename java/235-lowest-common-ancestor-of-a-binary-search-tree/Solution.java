// Leetcode 235-lowest-common-ancestor-of-a-binary-search-tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode p, q;
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p.val <= q.val ? p : q;
        this.q = p.val > q.val ? p : q;
        postorder(root);
        return res;
    }

    public void postorder(TreeNode root) {
        if (p.val <= root.val && q.val > root.val || root == p || root == q) {
            res = root;
            return;
        }
        else if (q.val <= root.val) {
            postorder(root.left);
            return;
        }
        else {
            postorder(root.right);
            return;
        }
    }
}