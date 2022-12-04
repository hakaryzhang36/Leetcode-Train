// Leetcode 152-maximum-product-subarray
// mark
class Solution {
    public int maxProduct(int[] nums) {
        // max[i], 以 nums[i] 结尾的连续子序列最大乘积
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
            }
            else {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
            }
        }

        int res = max[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(max[i], res);
        }
        return res;
    }
}