// Leetcode 1-two-sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (i < nums.length) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            else {
                map.put(target-nums[i], i);
            }
            i++;
        }
        return null;
    }
}