// Leetcode 53-maximum-subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        
        int minPreSum = preSum[0];
        int max = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(max, preSum[i] - Math.min(minPreSum, 0));
            minPreSum = Math.min(minPreSum, preSum[i]);
        }
        return max;
    }
}