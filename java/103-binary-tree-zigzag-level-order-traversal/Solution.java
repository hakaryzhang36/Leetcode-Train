// Leetcode 103-binary-tree-zigzag-level-order-traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();

        if(root == null) return r;

        q.addFirst(root);

        boolean l2r = true;

        while(!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            Deque<TreeNode> qt = new ArrayDeque<>();
            while(!q.isEmpty()) {
                TreeNode n = l2r ? q.pollFirst() : q.pollLast();
                l.add(n.val);
                if(l2r) {
                    if(n.left != null) qt.addLast(n.left);
                    if(n.right != null) qt.addLast(n.right);
                }
                else {
                    if(n.right != null) qt.addFirst(n.right);
                    if(n.left != null) qt.addFirst(n.left);
                }
                
            }
            r.add(l);
            q = qt;
            l2r = !l2r;
        }

        return r;
    }
}