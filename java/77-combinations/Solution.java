// Leetcode 77-combinations
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        recurse(n, k, path, res);
        return res;
    }
    public void recurse(int n, int k, LinkedList<Integer> path, List<List<Integer>> res) {
        // Step 1: if length == k, write in res and return
        if (path.size() == k) {
            res.add(new ArrayList(path));
            return;
        }

        // Step 2: add new num in path, recurse
        int start = path.size() == 0 ? 1 : path.get(path.size() - 1) + 1;
        int end = n - (k - path.size()) + 1;
        for (int i = start; i <= end; i++) {
            path.add(i);
            recurse(n, k, path, res);
            path.removeLast();
        }

        return;
    }
}