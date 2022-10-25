// Leetcode 106-construct-binary-tree-from-inorder-and-postorder-traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Return single node
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        
        // Create root
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

        // Split inorder from root, get leftLen and rightLen.
        int leftLen = 0, rightLen = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
            leftLen++;
        }
        rightLen = inorder.length - leftLen - 1;
        
        // Create new left inorder and postorder
        if (leftLen != 0) {
            int[] leftInorder = new int[leftLen];
            for (int i = 0; i < leftLen; i++) {
                leftInorder[i] = inorder[i];
            }
            int[] leftPostorder = new int[leftLen];
            for (int i = 0; i < leftLen; i++) {
                leftPostorder[i] = postorder[i];
            }
            root.left = buildTree(leftInorder, leftPostorder);
        }
        
        // Create right left inorder and postorder
        if (rightLen != 0) {
            int[] rightInorder = new int[rightLen];
            for (int i = 0; i < rightLen; i++) {
                rightInorder[i] = inorder[i + leftLen + 1];
            }
            int[] rightPostorder = new int[rightLen];
            for (int i = 0; i < rightLen; i++) {
                rightPostorder[i] = postorder[i + leftLen];
            }
            root.right = buildTree(rightInorder, rightPostorder);
        }
        
        return root;
    }
}