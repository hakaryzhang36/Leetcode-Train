// Leetcode offer-03
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return i;
            else set.add(i);
        }
        return nums[0];
    }
}
