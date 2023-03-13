// Leetcode 199-binary-tree-right-side-view
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }


        Deque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(root);
        ans.add(root.val);


        while (!q.isEmpty()) {
            // 该层最右值
            TreeNode r = new TreeNode(1000);
            // 下一层的节点队列
            Deque<TreeNode> newQ = new ArrayDeque<>();
            while (!q.isEmpty()) {
                TreeNode p = q.pollFirst();
                if (p.left != null) {
                    r = p.left;
                    newQ.addLast(p.left);
                }
                if (p.right != null) {
                    r = p.right;
                    newQ.addLast(p.right);
                }
            }
            // 写进 ans
            if (r.val != 1000) {
                ans.add(r.val);
            }
            q = newQ;
        }

        return ans;
    }
}