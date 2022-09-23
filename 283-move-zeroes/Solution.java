// Leetcode 283
public class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, k = 0; k < nums.length; ) {
            if (nums[k] != 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i++;
                k++;
            }
            else {
                k++;
            }
        }
    }
}