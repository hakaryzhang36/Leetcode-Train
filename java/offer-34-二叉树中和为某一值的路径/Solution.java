// Leetcode offer-34-二叉树中和为某一值的路径
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
    List<List<Integer>> res = new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        reverse(root, 0, new LinkedList<>());
        return res;
    }

    private void reverse(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }

        sum += root.val;
        list.add(root.val);

        // terminal
        if (root.left == null && root.right == null) {
            if (target == sum) {
                res.add(new ArrayList(list));
            }
            list.remove(list.size()-1);
            return;
        }

        // reverse
        reverse(root.right, sum, list);
        reverse(root.left, sum, list);
        list.remove(list.size()-1);
        return;
    }
}