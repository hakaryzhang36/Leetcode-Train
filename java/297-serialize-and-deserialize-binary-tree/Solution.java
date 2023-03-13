// Leetcode 297-serialize-and-deserialize-binary-tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null) {
            return "X,";
        }
        else {
            String s = root.val + ",";
            return s + serialize(root.left) + serialize(root.right);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr.length==1 && arr[0].equals("X")) {
            return null;
        }
        TreeNode root = new TreeNode();
        de(arr, 0, root);
        return root;
    }

    private int de(String[] arr, int p, TreeNode root) {
        if (arr[p].equals("X")) {
            return p;
        }

        // 赋值
        root.val = Integer.valueOf(arr[p]);
        
        // de left
        root.left = new TreeNode(1001);
        int le = de(arr, p+1, root.left);
        if (root.left.val == 1001) {
            root.left = null;
        }

        // de right
        root.right = new TreeNode(1001);
        int re = de(arr, le+1, root.right);
        if (root.right.val == 1001) {
            root.right = null;
        }

        return re;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));