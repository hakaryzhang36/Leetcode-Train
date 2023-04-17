// Leetcode 96-unique-binary-search-trees
// mark
// done
class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= i-1; k++) {
                nums[i] += nums[k]*nums[i-k-1];
            }
        }
        return nums[n];
    }
}