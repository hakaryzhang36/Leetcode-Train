// Leetcode 15-3sum
// mark
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int p = 0;
        while(p < nums.length-2) {
            int q = p+1;
            while(q < nums.length-1) {
                int target = -(nums[p] + nums[q]);
                boolean b = find(target, nums, q+1, nums.length-1);
                if (b) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[p]);
                    l.add(nums[q]);
                    l.add(target);
                    res.add(l);
                }
                q = move(q, nums);
            }
            p = move(p, nums);
        }
        return res;
    }

    public boolean find(int target, int[] nums, int h, int e) {
        if (h > e) return false;
        if (target < nums[h] || target > nums[e]) return false;
        int m = (h + e) / 2;
        if (nums[m] == target) return true;
        if (nums[m] > target) return find(target, nums, h, m-1);
        if (nums[m] < target) return find(target, nums, m+1, e);
        return false;
    }

    public int move(int p, int[] nums) {
        p = p + 1;
        while(p < nums.length && nums[p] == nums[p-1]) p++;
        return p;
    }
}