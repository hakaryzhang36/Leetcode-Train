// Leetcode 46-permutations
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] picked = new boolean[nums.length];
        reverse(list, picked, nums);
        return res;
    }

    private void reverse(LinkedList<Integer> list, boolean[] picked, int[] nums) {
        // terminal
        if(list.size() == nums.length) {
            res.add(new LinkedList<Integer>(list));
            return;
        }

        // choose a unpicked number
        for (int i = 0; i < picked.length; i++) {
            if (!picked[i]) {
                picked[i] = true;
                list.add(nums[i]);
                reverse(list, picked, nums);
                picked[i] = false;
                list.removeLast();
            }
        }
    }
}