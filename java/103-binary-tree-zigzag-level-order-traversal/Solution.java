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
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(root);
        boolean goL = false;
        while (!q.isEmpty()) {
            Deque<TreeNode> t = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode node = null;
                if (goL) {
                    node = q.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        t.addFirst(node.right);
                    }                    
                    if (node.left != null) {
                        t.addFirst(node.left);
                    }
                }
                else {
                    node = q.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        t.addLast(node.left);
                    }
                    if (node.right != null) {
                        t.addLast(node.right);
                    } 
                }
            }
            q = t;
            goL = !goL;
            lists.add(list);
        }
        return lists;
    }

}