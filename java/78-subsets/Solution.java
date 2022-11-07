// Leetcode 78-subsets
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>());
        reverse(nums, new LinkedList<Integer>(), 0);
        return res;
    }

    private void reverse(int[] nums, LinkedList<Integer> set, int p) {
        // termination
        if (p == nums.length) {
            return;
        }

        // put a new set into set
        while (p < nums.length) {
            set.add(nums[p]);
            // add into res
            res.add(new ArrayList(set));
            // reverse
            reverse(nums, set, p + 1);
            set.removeLast();
            p++;
        }
        return;
    }
}