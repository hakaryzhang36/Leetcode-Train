// Leetcode 102-binary-tree-level-order-traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            Queue<TreeNode> qn = new ArrayDeque<>();
            List<Integer> l = new ArrayList<>();
            while(!q.isEmpty()) {
                TreeNode n = q.poll();
                l.add(n.val);
                if(n.left != null) qn.add(n.left);
                if(n.right != null) qn.add(n.right);
            }
            if(!l.isEmpty()) res.add(l);
            q = qn;
        }
        return res;
    }
}