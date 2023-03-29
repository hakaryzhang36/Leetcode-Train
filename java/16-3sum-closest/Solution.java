// Leetcode 16-3sum-closest
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int m = 0; m < nums.length-2; m++) {
            for (int i = m + 1, j = nums.length-1; i < j;) {
                int sum = nums[m] + nums[i] + nums[j];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum == target) {
                    return sum;
                }
                else if (sum > target) {
                    j--;
                }
                else {
                    i++;
                }
            }
        }
        return ans;
    }
}