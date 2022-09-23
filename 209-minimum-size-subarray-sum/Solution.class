// Leetcode 209
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0, top = 0, sum = nums[0];
        int minLength = 1000000;
        while (top < nums.length) {
            if (sum >= target) {
                int newLength = top - low + 1;
                if (newLength < minLength) {
                    minLength = newLength;
                }
                // gen new sum
                sum -= nums[low];
                if (++low < nums.length && low > top) {
                    top = low;
                    sum += nums[top];
                }
            }
            else {
                if (++top < nums.length) {
                    sum += nums[top];
                }
            }
        }
        if (minLength == 1000000) {
            return 0;
        }
        else return minLength;
    }
}