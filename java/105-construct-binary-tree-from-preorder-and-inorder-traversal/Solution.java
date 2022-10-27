// Leetcode 105-construct-binary-tree-from-preorder-and-inorder-traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Step 1: Generate root
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }

        // Step 2: Find root position in inorder list
        int pos = 0;
        while (pos < inorder.length && inorder[pos] != root.val) {
            pos++;
        }

        // Step 3: Create left sub inorder list
        int[] inLeft = new int[pos];
        for (int i = 0; inLeft.length > 0 && i < inLeft.length; i++) {
            inLeft[i] = inorder[i];
        }

        // Step 4: Create right sub inorder list
        int[] inRight = new int[inorder.length - pos - 1];
        for (int i = 0; inRight.length > 0 && i < inRight.length; i++) {
            inRight[i] = inorder[i + pos + 1];
        }

        // Step 5: Create left preorder list
        int[] preLeft = new int[inLeft.length];
        for (int i = 0; preLeft.length > 0 && i < preLeft.length; i++) {
            preLeft[i] = preorder[1 + i];
        }

        // Step 6: Create right preorder list
        int[] preRight = new int[inRight.length];
        for (int i = 0; preRight.length > 0 && i < preRight.length; i++) {
            preRight[i] = preorder[preLeft.length + i + 1];
        }

        // Step 7: Generate child
        if (inLeft.length > 0) {
            root.left = buildTree(preLeft, inLeft);
        }
        if (inRight.length > 0) {
            root.right = buildTree(preRight, inRight);
        }

        return root;
    }
}