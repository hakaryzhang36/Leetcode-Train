// Leetcode 654-maximum-binary-tree
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
        Deque<TreeNode> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // first node
            if (q.size() == 0) {
                q.addLast(new TreeNode(nums[i]));
                continue;
            }

            // if nums[i] < q.tail, it means nums[i] is q.tail's right child
            if (nums[i] < q.peekLast().val) {
                q.addLast(new TreeNode(nums[i]));
            }
            else {
                TreeNode top = new TreeNode(nums[i]);
                while (q.size() > 0 && nums[i] > q.peekLast().val) {
                    TreeNode o_left = top.left;
                    q.peekLast().right = top.left;
                    top.left = q.removeLast();
                }
                q.addLast(top);
            }
        }
        
        // Link all of nodes in q together
        while (q.size() > 1) {
            TreeNode last = q.removeLast();
            q.peekLast().right = last;
        }

        return q.removeLast();
    }
}