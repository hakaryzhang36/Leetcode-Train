// Leetcode 448-find-all-numbers-disappeared-in-an-array
// mark
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int o = num%nums.length;
            if (o == 0) {
                o = nums.length;
            }
            nums[o-1] += nums.length;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                list.add(i+1);
            }
        }
        return list;
    }
}