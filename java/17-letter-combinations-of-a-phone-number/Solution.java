// Leetcode 17-letter-combinations-of-a-phone-number
class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        recurse(sb, 0, digits);
        return res;
    }

    public void recurse(StringBuilder sb, int p, String digits) {
        if (p == digits.length()) {
            res.add(sb.substring(0));
            return;
        }
        char[] chars = map[(int)digits.charAt(p) - (int)'2'].toCharArray();
        for (char c : chars) {
            sb.append(c);
            recurse(sb, p + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}