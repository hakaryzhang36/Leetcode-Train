// Leetcode 53-maximum-subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], nums[i]+sum[i-1]);
            res = Math.max(res, sum[i]);
        }
        return res;
    }
}