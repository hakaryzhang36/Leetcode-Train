// Leetcode 40-combination-sum-ii
// mark
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // get map
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        for (Integer num : candidates) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 1) {
                nums.add(num);
            }
        }
        System.out.println(nums.toString());

        LinkedList<Integer> list = new LinkedList<>();
        recurse(list, 0, 0, map, nums, target);

        return res;
    }

    public void recurse(LinkedList<Integer> list, int p, int sum, Map<Integer, Integer> map, List<Integer> nums, int target) {
        // candidates overflow
        if (p == nums.size()) {
            return;
        }

        // add nums[p]
        int num = nums.get(p);
        int i = 0;
        while (i <= map.get(num) - 1 && sum + num  <= target) {
            list.add(num);
            sum += num;
            // System.out.println(sum);
            i++;
        }
        // meet condition, add in res
        if (sum == target) {
            res.add(new ArrayList(list));
            list.removeLast();
            sum -= num;
            i--;
        }
        // pop candidates[p], try to recurse (sum must < target)
        while (i >= 1) {
            System.out.println(list.toString());
            System.out.println(sum);
            recurse(list, p + 1, sum, map, nums, target);
            list.removeLast();
            i--;
            sum -= num;
        }

        // recurse without candidates[p]
        recurse(list, p + 1, sum, map, nums, target);
        
        return;
    }
}