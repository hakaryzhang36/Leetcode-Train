// Leetcode 39-combination-sum
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort canditates
        Arrays.sort(candidates);

        LinkedList<Integer> list = new LinkedList<>();
        recurse(list, 0, 0, candidates, target);

        return res;
    }

    public void recurse(LinkedList<Integer> list, int p, int sum, int[] candidates, int target) {
        // candidates overflow
        if (p >= candidates.length) {
            return;
        }

        int i = 0;
        // add candidates[p] as much as possible and recurse
        while (sum + candidates[p] <= target) {
            list.add(candidates[p]);
            sum += candidates[p];
            // System.out.println(sum);
            i++;
        }
        // meet condition, add in res
        if (sum == target) {
            res.add(new ArrayList(list));
            list.removeLast();
            sum -= candidates[p];
            i--;
        }
        // pop candidates[p], try to recurse (sum must < target)
        while (i >= 1) {
            // System.out.println(list.toString());
            // System.out.println(sum);
            recurse(list, p + 1, sum, candidates, target);
            list.removeLast();
            i--;
            sum -= candidates[p];
        }
        // recurse without candidates[p]
        recurse(list, p + 1, sum, candidates, target);
        return;
    }
}