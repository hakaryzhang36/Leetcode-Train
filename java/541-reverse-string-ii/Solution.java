// Leetcode 541-reverse-string-ii
class Solution {
    public String reverseStr(String s, int k) {
        int p = 2 * k - 1;
        int i = 0, j = k - 1;
        StringBuilder res = new StringBuilder();
        while (p < s.length()) {
            // reverse substring
            res.append(reverse(s.substring(i, j + 1)));
            res.append(s.substring(j + 1, p + 1));
            i = p + 1;
            j = i + k - 1;
            p = p + 2 * k;
        }
        // reverse the last 2k substring
        if (i < s.length()) {
            if (j < s.length()) {
                // convert
                res.append(reverse(s.substring(i, j + 1)));
                res.append(s.substring(j + 1, s.length()));
            }
            else {
                // convert
                res.append(reverse(s.substring(i, s.length())));
            }
        }
        return res.toString();
    }

    public String reverse(String str) {
        char[] cstr = str.toCharArray();
        int i = 0, j = cstr.length - 1;
        while (i < j) {
            char t = cstr[i];
            cstr[i] = cstr[j];
            cstr[j] = t;
            i++;
            j--;
        }
        return new String(cstr);
    }
}