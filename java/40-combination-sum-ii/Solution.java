// Leetcode 40-combination-sum-ii
// mark 2
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int target = 0;
    int[] candidates = null;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;

        sub(0, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void sub(int start, ArrayList<Integer> list, int sum) {
        int last = -1;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] == last) {
                continue;
            }
            if (sum + candidates[i] < target) {
                list.add(candidates[i]);
                sub(i+1, list, sum+candidates[i]);
                list.remove(list.size()-1);
            }
            else if (sum + candidates[i] == target) {
                list.add(candidates[i]);
                ans.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            last = candidates[i];
        }
    }
}