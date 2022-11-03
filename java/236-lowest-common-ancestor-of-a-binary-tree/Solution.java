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

    public boolean postorder(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean l = postorder(root.left);
        boolean r = postorder(root.right);
        if ((l && r) || (l || r) && (root == p || root == q)) { // root is ancestor
            res = root;
            return true;
        }
        if (root == p || root == q || l || r) {   // find one target (root or in subTree)
            return true;
        }
        return false;
    }
}