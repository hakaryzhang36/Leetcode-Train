// Leetcode 1749-maximum-absolute-sum-of-any-subarray
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int max = nums[0];
        int min = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], nums[i] + dpMax[i-1]);
            dpMin[i] = Math.min(nums[i], nums[i] + dpMin[i-1]);
            max = Math.max(max, dpMax[i]);
            min = Math.min(min, dpMin[i]);
        }

        int a = Math.abs(max);
        int b = Math.abs(min);

        return Math.max(0, Math.max(a, b));
    }
}
