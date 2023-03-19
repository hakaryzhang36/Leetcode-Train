// Leetcode 6324-maximize-greatness-of-an-array
class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                count++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}