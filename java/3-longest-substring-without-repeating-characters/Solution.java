// Leetcode 3-longest-substring-without-repeating-characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int p = 0, q = 1;
        int ans = 1;
        map.put(s.charAt(0), 1);
        for (;q < s.length(); q++) {
            char c = s.charAt(q);
            while (map.containsKey(c) && p < q) {
                char t = s.charAt(p);
                map.put(t, map.get(t)-1);
                if (map.get(t) == 0) {
                    map.remove(t);
                }
                p++;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            ans = Math.max(ans, q-p+1);
        }

        return ans;
    }
}