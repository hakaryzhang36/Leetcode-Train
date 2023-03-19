// Leetcode 15-3sum
// mark
class Solution {
    Set<String> mark = new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k <= nums.length-3; k++) {
            for (int i=k+1, j=nums.length-1; i<j;) {
                if (nums[k] + nums[i] + nums[j] == 0) {
                    if (check(nums[k], nums[i], nums[j])) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[k]);
                        l.add(nums[i]);
                        l.add(nums[j]);
                        ans.add(l);
                    }
                    i++;
                }
                else if (nums[k] + nums[i] + nums[j] > 0) {
                    j--;
                }
                else {
                    i++;
                }
            }
        }
        return ans;
    }

    private boolean check(int a, int b, int c) {
        int t1 = Math.min(Math.min(a, b), c);
        int t2 = Math.max(Math.max(a, b), c);
        int t3 = -(t1+t2);
        String s = String.valueOf(t1) + " " + String.valueOf(t2) + " " + String.valueOf(t3);
        if (mark.contains(s)) {
            return false;
        }
        else {
            mark.add(s);
            return true;
        }
    }
}