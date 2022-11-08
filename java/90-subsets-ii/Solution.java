// Leetcode 90-subsets-ii
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        reverse(nums, 0, new LinkedList<Integer>());
        return res;
    }

    private void reverse(int[] nums, int p, LinkedList<Integer> set) {
        // terminal condition
        if (p == nums.length) {
            res.add(new ArrayList(set));
            return;
        }

        int k = p;
        while (k + 1 < nums.length && nums[p] == nums[k + 1]) {
            k++;
        }
        int sameNum = k - p + 1;
        // i: add i nums[p] in set
        for (int i = 0; i <= sameNum; i++) {
            if (i == 0) {
                reverse(nums, k + 1, set);
            }
            else {
                set.add(nums[p]);
                reverse(nums, k + 1, set);
            }
        }
        // clean i nums[p] in set
        for (int i = 0; i < sameNum; i++) {
            set.removeLast();
        }
        return;
    }
}