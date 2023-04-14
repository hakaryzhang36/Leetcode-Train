// Leetcode 238-product-of-array-except-self
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        for (int i = 0, n = 1; i < nums.length; i++) {
            pre[i] = (n = n * nums[i]);
        }
        for (int i = nums.length-1, n = 1; i >= 0; i--) {
            post[i] = (n = n * nums[i]);
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = (i-1>=0? pre[i-1] : 1) * (i+1<nums.length? post[i+1] : 1);
        }
        return res;
    }
}