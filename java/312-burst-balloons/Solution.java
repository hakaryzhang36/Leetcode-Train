// Leetcode 312-burst-balloons
// mark
class Solution {
    int max = 0;
    public int maxCoins(int[] nums) {

        // d[i][j] 表示 i 到 j 的开区间能得到的最大价值
        int[][] d = new int[nums.length][nums.length];
        
        // init
        for (int k = 0; k < nums.length; k++) {
            int val;
            if (k == 0) {
                d[k][k] = nums[k] * nums[k + 1];
            }
            else if (k == nums.length - 1) {
                d[k][k] = nums[k] * nums[k - 1];
            }
            else {
                d[k][k] = nums[k - 1] * nums[k] * nums[k + 1];
            }
        }

        for (int size = 2; size <= nums.length; size++) {
            // 计算所有长度为 size 的区间的最大值
            for (int i = 0, j = i + size - 1; j < nums.length; i++, j++) {
                // 计算 i 到 j 开区间的最大值
                // 依次假设区间内的气球为最后戳爆的气球
                // 最后戳爆的气球能产生的价值一定为 nums[k - 1] * nums[k] * nums[k+1]
                //（相比于递归，动态规划往往都是有更好复杂度的）
                for (int k = i; k <= j; k++) {
                    int val;
                    if (k == 0) {
                        val = nums[k] * nums[k + 1];
                    }
                    else if (k == nums.length - 1) {
                        val = nums[k] * nums[k - 1];
                    }
                    else {
                        val = nums[k - 1] * nums[k] * nums[k + 1];
                    }
                    int t = d[i][k] + val + d[k][j];
                    if (t > d[i][j]) {
                        d[i][j] = t;
                    }
                }
            }
        }


        return d[0][nums.length - 1];
    }

}