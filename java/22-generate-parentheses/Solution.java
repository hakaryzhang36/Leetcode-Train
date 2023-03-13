// Leetcode 22-generate-parentheses
// mark
// done
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        gen(0, 0, n, "");
        return ans;
    }

    private void gen(int pre, int back, int n, String s) {
        if (pre == n && back == n) {
            ans.add(s);
        }
        if (pre < n) {
            gen(pre+1, back, n, s + "(");
        }
        if (back < pre) {
            gen(pre, back+1, n, s+")");
        }
    }
}