// Leetcode 47-permutations-ii
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        reverse(new LinkedList<>(), new boolean[nums.length], nums);
        return res;
    }

    private void reverse(LinkedList<Integer> list, boolean[] picked, int[] nums) {
        // terminal
        if(list.size() == nums.length) {
            res.add(new LinkedList<Integer>(list));
            return;
        }

        // choose a unpicked number
        Set<Integer> isPickedInCurLevel = new HashSet<>(); 
        for (int i = 0; i < nums.length; i++) {
            if (!picked[i] && !isPickedInCurLevel.contains(nums[i])) {
                isPickedInCurLevel.add(nums[i]);
                picked[i] = true;
                list.add(nums[i]);
                reverse(list, picked, nums);
                picked[i] = false;
                list.removeLast();
            }
        }
    }
}