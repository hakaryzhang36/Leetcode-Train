// Leetcode 76-minimum-window-substring
// mark
// done
class Solution {
    public String minWindow(String s, String t) {
        int[] ct = new int[52];
        int n = t.length();
        for (int i = 0; i < t.length(); i++) {
            ct[getPos(t.charAt(i))]++;
        }

        // find start position
        int p = 0;
        while (p < s.length() && ct[getPos(s.charAt(p))] == 0) {
            p++;
        }

        if (p == s.length()) return "";

        // mark list
        int[] mark = new int[52];
        mark[getPos(s.charAt(p))] = 1;
        int c = 1;
        if (n == c) return t;

        String res = "";
        for (int q = p+1; q < s.length(); q++) {
            char ch = s.charAt(q);
            int pos = getPos(ch);
            if (ct[pos] == 0) {
                continue;
            }
            if (ct[pos] > mark[pos]) {
                mark[pos]++;
                c++;
            }
            else {
                mark[pos]++;
                while (mark[getPos(s.charAt(p))] > ct[getPos(s.charAt(p))] || ct[getPos(s.charAt(p))] == 0) {
                    mark[getPos(s.charAt(p))] = Math.max(0, mark[getPos(s.charAt(p))]-1);
                    p++;
                }
            }
            if (c == n) {
                res = res.equals("") || res.length() > q-p+1 ? s.substring(p, q+1) : res;
            }
        }

        return res;
        
    }

    public int getPos(char c) {
        if (c >= 'a' && c <= 'z') return c-'a';
        else return 26 + (c - 'A');
    }
}