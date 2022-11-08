// Leetcode 491-increasing-subsequences
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<Integer> skip = new HashSet<>();
        reverse(nums, 0, new LinkedList<Integer>(), skip);
        return res;
    }

    private void reverse(int[] nums, int p, LinkedList<Integer> list, Set<Integer> skip) {
        // terminal
        if (p == nums.length) {
            if(list.size() >= 2) {
                res.add(new ArrayList(list));
            }
            return;
        }

        // if none of skip number == nums[p], try to add nums[p] in set
        if (!skip.contains(Integer.valueOf(nums[p]))) {
            // try to add nums[p] in set, reverse
            if (list.size() == 0 || nums[p] >= list.getLast()) {
                list.add(nums[p]);
                reverse(nums, p + 1, list, new HashSet<Integer>());
                list.removeLast();
            }
            
            // try to skip nums[p], reverse
            skip.add(nums[p]);
            reverse(nums, p + 1, list, skip);
            skip.remove(nums[p]);
        }
        else {
            // nums[p] already been skip, reverse
            reverse(nums, p + 1, list, skip);
        }
        return;
    }
}