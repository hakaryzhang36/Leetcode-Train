// Leetcode 1382-balance-a-binary-search-tree
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
    List<Integer> list = new ArrayList<>(); 
    public TreeNode balanceBST(TreeNode root) {
        // inorder
        inorder(root);
        System.out.println(list);
        return gen(0, list.size() - 1);
    }

    private TreeNode gen(int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(list.get(i));
        }
        else {
            int mid = (i + j) >> 1;
            TreeNode node = new TreeNode(list.get(mid));
            node.left = gen(i, mid - 1);
            node.right = gen(mid + 1, j);
            return node;
        }
    }

    private void inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left);
        }

        list.add(root.val);

        if (root.right != null) {
            inorder(root.right);
        }
    }
}