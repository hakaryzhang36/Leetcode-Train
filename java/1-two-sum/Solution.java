// Leetcode 1-two-sum
// mark
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (target == 0 && nums[i] == 0) {
                    return new int[]{i, map.get(0)};
                }
                map.put(-nums[i], i);
            }
            else {
                map.put(nums[i], i);
            }
        }
        Arrays.sort(nums);
        for (int i = 0, k = nums.length - 1; i != k;){
            if (nums[i] + nums[k] == target) {
                if (nums[i] == nums[k]) {
                    return new int[]{map.get(nums[i]), map.get(-nums[k])};
                }
                else {
                    return new int[]{map.get(nums[i]), map.get(nums[k])};
                }
            }
            if (nums[i] + nums[k] > target) {
                k--;
            }
            else {
                i++;
            }
        }
        return null;
    }
}