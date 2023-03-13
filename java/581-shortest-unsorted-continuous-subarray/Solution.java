// Leetcode 581-shortest-unsorted-continuous-subarray
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int ans = 0;
        int min = nums[0];
        int last = nums[0];
        int ss = -1, se = -1; 
        for (int len = 2; len <= nums.length; len++) {
            int end = nums[len-1];
            if (last > end) {
                se = len - 1;       // 更新子数组尾
                if (ss == -1) {
                    // ss向前找到比end大的位置（只会向前一次）
                    ss = 0;
                    while (nums[ss] <= end) {
                        ss++;
                    }
                }
                else {
                    // ss后退找到比end小的位置后一位
                    while (ss-1 >= 0 && nums[ss-1] > end) {
                        ss--;
                    }
                }
                // 计算子数组长度
                ans = se - ss + 1;
            }
            else {
                last = end;
            }
        }
        return ans;
    }
}