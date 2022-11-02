// Leetcode 236-lowest-common-ancestor-of-a-binary-tree
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
        this.p = p;
        this.q = q;
        inorder(root);
        return res;
    }

    public boolean inorder(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean l = inorder(root.left);
        boolean r = inorder(root.right);
        if (res != null) {
            return true;    // finish, clear stack
        }
        if ((l || r) && (root == p || root == q)) { // root is ancestor
            res = root;
            return true;
        }
        if (root == p || root == q) {   // root is one of target
            return true;
        }
        if (l && r) {   // root is ancestor
            res = root;
            return true;
        }
        if (l || r) {   // find one
            return true;
        }
        return false;
    }
}