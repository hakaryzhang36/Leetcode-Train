// Leetcode 1144-decrease-elements-to-make-array-zigzag
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int ans1 = 0;
        for (int i = 0; i < nums.length; i+=2) {
            int t = nums[i];
            if (i-1 >= 0 && nums[i-1] <= t) {
                ans1 += t - nums[i-1] + 1;
                t = nums[i-1] - 1;
            }
            if (i+1 < nums.length && nums[i+1] <= t) {
                ans1 += t - nums[i+1] + 1;
                t = nums[i+1] - 1;
            }
        }

        int ans2 = 0;
        for (int i = 1; i < nums.length; i+=2) {
            int t = nums[i];
            if (i-1 >= 0 && nums[i-1] <= t) {
                ans2 += t - nums[i-1] + 1;
                t = nums[i-1] - 1;
            }
            if (i+1 < nums.length && nums[i+1] <= t) {
                ans2 += t - nums[i+1] + 1;
                t = nums[i+1] - 1;
            }
        }

        return Math.min(ans1, ans2);
    }
}