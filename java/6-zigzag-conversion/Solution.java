// Leetcode 6-zigzag-conversion
class Solution {
    public String convert(String s, int numRows) {
        
        int s1 = numRows, s2 = Math.max(0, numRows - 2);
        String[] strs = new String[numRows + 1];
        boolean down = true;
        for (int i = 0, r = 1; i < s.length(); i++) {
            if (strs[r] == null) {
                strs[r] = new String();
            }
            strs[r] += s.charAt(i);
            if (down) {
                if (r + 1 <= numRows) {
                    r++;
                }
                else if (r-1 > 0){
                    down = false;
                    r--;
                }
            }
            else {
                if (r - 1 > 0) {
                    r--;
                }
                else if (r+1 <= numRows){
                    down = true;
                    r++;
                }
            }
        }

        String ans = "";
        for (int r = 1; r <= numRows && strs[r] != null; r++) {
            ans += strs[r];
        }
        return ans;
    }
}