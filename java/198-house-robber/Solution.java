// Leetcode 198-house-robber
class Solution {
    public int rob(int[] nums) {
        int[][] coins = new int[nums.length][2];
        coins[0][0] = 0;
        coins[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            coins[i][0] = Math.max(coins[i-1][0], coins[i-1][1]);
            coins[i][1] = coins[i-1][0] + nums[i];
        }
        return Math.max(coins[nums.length-1][0], coins[nums.length-1][1]);
    }
}