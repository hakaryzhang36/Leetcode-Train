// Leetcode 33-search-in-rotated-sorted-array
class Solution {
    public int search(int[] nums, int target) {
        return subSerach(nums, target, 0, nums.length-1);
    }

    public int subSerach(int[] nums, int target, int p, int q) {
        if(p > q) return -1;
        int m = (p+q)/2;
        if(nums[p] > nums[q]) {
            int r1 = subSerach(nums, target, p, m);
            int r2 = subSerach(nums, target, m+1, q);
            return Math.max(r1, r2);
        }
        else {
            if (nums[m] == target) return m;
            if (nums[m] > target) return subSerach(nums, target, p, m-1);
            if (nums[m] < target) return subSerach(nums, target, m+1, q);
        }
        return -1;
    }
}