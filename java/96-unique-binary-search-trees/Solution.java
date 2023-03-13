// Leetcode 96-unique-binary-search-trees
// mark
class Solution {
    int[] mark;
    int ans = 0;
    public int numTrees(int n) {
        mark = new int[n+1];
        mark[0] = 1;
        mark[1] = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans + (genTree(i-1)*genTree(n-i));
        }
        return ans;
    }

    private int genTree(int size) {
        int ans = 0;
        if (mark[size] != 0) {
            return mark[size];
        }
        else {
            for (int i = 1; i <= size; i++) {
                ans = ans + (genTree(i-1)*genTree(size-i));
            }
        }
        return ans;
    }
    
}