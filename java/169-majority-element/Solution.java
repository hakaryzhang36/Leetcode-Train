// Leetcode 169-majority-element
class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length && count < nums.length / 2 + 1; i++) {
            if (nums[i] != res) {
                count--;
            }
            else {
                count++;
            }
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}