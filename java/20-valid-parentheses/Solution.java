// Leetcode 20-valid-parentheses
class Solution {
    public boolean isValid(String s) {
        Stack<Character> q = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (q.isEmpty() || q.peek() != '(') return false;
                else q.pop();
            }
            else if (s.charAt(i) == ']') {
                if (q.isEmpty() || q.peek() != '[') return false;
                else q.pop();
            }
            else if (s.charAt(i) == '}') {
                if (q.isEmpty() || q.peek() != '{') return false;
                else q.pop();
            }
            else {
                q.push(s.charAt(i));
            }
        }
        if (!q.isEmpty()) return false;
        return true;
    }
}