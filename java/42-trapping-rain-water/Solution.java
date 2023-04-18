// Leetcode 42-trapping-rain-water
// mark
// wonderful idea!
class Solution {
    public int trap(int[] height) {
        int[] pre_max = new int[height.length];
        int[] suf_max = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            pre_max[i] = i==0 ? 0 : Math.max(height[i-1], pre_max[i-1]);
        }
        for (int i = height.length-1; i >= 0; i--) {
            suf_max[i] = i==height.length-1 ? 0 : Math.max(height[i+1], suf_max[i+1]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= pre_max[i] || height[i] >= suf_max[i]) continue;
            res += Math.min(pre_max[i], suf_max[i]) - height[i];
        }
        return res;
    }
}