// Leetcode 416-partition-equal-subset-sum
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum%2 == 1) {
            return false;
        }
        boolean[] mark = new boolean[sum/2+1];
        mark[0] = true;
        for (int n : nums) {
            for (int i = sum/2; i >= 1; i--) {
                if (i-n >= 0 && mark[i-n]) {
                    mark[i] = true;
                }
            }
        }

        return mark[sum/2];
    }
}