// Leetcode 18-4sum
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                long sum = (long)nums[i] + (long)nums[j];
                int h = j+1;
                int e = nums.length-1;
                while (h < e) {
                    if (sum + (long)nums[h] + (long)nums[e] == (long)target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[h]);
                        list.add(nums[e]);
                        ans.add(list);
                        int t = nums[h];
                        while (h+1 < nums.length && nums[h+1] == t) {
                            h++;
                        }
                        h++;
                    }
                    else if (sum + nums[h] + nums[e] < target) {
                        h++;
                    }
                    else {
                        e--;
                    }
                }
                int t = nums[j];
                while (j+1 < nums.length && nums[j+1] == t) {
                    j++;
                }
            }
            // System.out.println(ans.size());
            int t = nums[i];
            while (i+1 < nums.length && nums[i+1] == t) {
                i++;
            }
        }
        return ans;
    }
}