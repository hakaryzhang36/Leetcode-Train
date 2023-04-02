// Leetcode 20-valid-parentheses
class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (q.size() != 0 && q.peekFirst() == '(') {
                    q.pollFirst();
                }
                else return false;
            }
            else if (c == ']') {
                if (q.size() != 0 && q.peekFirst() == '[') {
                    q.pollFirst();
                }
                else return false;
            }
            else if (c == '}') {
                if (q.size() != 0 && q.peekFirst() == '{') {
                    q.pollFirst();
                }
                else return false;
            }
            else {
                q.addFirst(c);
            }
        }
        return q.size() == 0
    }
}