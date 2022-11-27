// Leetcode 55-jump-game
class Solution {
    public boolean canJump(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length && i <= m; i++) {
            if (i + nums[i] >= m) {
                m = i + nums[i];
                if (m >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}