// Leetcode 3-longest-substring-without-repeating-characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.getOrDefault(s.charAt(i), -1) < start) {
                ans = Math.max(i-start+1, ans);
            }
            else {
                start = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
        }
        return ans;
    }
}