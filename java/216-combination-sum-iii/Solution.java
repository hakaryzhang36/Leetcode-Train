// Leetcode 216-combination-sum-iii
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // Step 1: if out of range, return
        if (k < 1 || k > 9) {
            return res;
        }
        int min = (1 + k) * k / 2;
        int max = (9 - k + 1 + 9) * k / 2;
        if (n < min || n > max) {
            return res;
        }

        // Step 2: recurse
        LinkedList<Integer> list = new LinkedList<>();
        recurse(list, 0, n, k);

        return res;
    }

    public void recurse(LinkedList<Integer> list, int sum, int n, int k) {
        // Step 1: sum == n
        if (list.size() == k && sum == n) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        // Step 2: from start to 9, try to add in list
        int start = list.size() == 0 ? 1 : list.peekLast() + 1;
        for (int i = start; i <= 9; i++) {
            if (sum + i <= n) {
                list.add(i);
                recurse(list, sum + i, n, k);
                list.removeLast();
            }
        }

        return;
    }
}
    