// Leetcode 1023-camelcase-matching
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            int j = 0;
            boolean isMatch = true;
            for (int i = 0; i < q.length(); i++) {
                char ch = q.charAt(i);
                if (j < pattern.length() && ch == pattern.charAt(j)) {
                    j += 1;
                    continue;
                }
                if (ch >= 'A' && ch <= 'Z' && (j == pattern.length() || ch != pattern.charAt(j))) {
                    isMatch = false;
                    break;
                } 
            }
            if (j < pattern.length()) {
                isMatch = false;
            }
            res.add(isMatch);
        }

        return res;
    }
}