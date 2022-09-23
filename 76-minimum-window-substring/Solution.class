// Leetcode 76
public class Solution {
    public String minWindow(String s, String t) {
        // gen character hashmap
        int[] character = new int[128];
        for (char ch : t.toCharArray()) {
            character[ch]++;
        }
        for (int i = 0; i < character.length; i++) {
            character[i] = character[i] == 0 ? -999999999 : character[i];
        }
        // scan s
        int notMatch = t.length(); // count of not match character in t
        int minLow = -1, minTop = -1;
        for (int low = 0, top = 0; top < s.length(); top++) {
            if (character[s.charAt(top)] == -999999999) {
                continue;
            }
            else {
                character[s.charAt(top)]--;
                if (character[s.charAt(top)] >= 0) {
                    notMatch--;
                }
            }
            // move low, until notMatch > 0
            while (notMatch == 0) {
                // update substring min length
                int l = top - low + 1;
                if (l < minTop - minLow + 1 || minLow == -1) {
                    minLow = low;
                    minTop = top;
                }
                if (character[s.charAt(low)] != -999999999) {
                    character[s.charAt(low)]++;
                    if (character[s.charAt(low)] > 0) {
                        notMatch++;
                    }
                }
                low++;
            }
        }
        // return
        if (minLow > -1) {
            System.out.println(minLow);
            System.out.println(minTop);
            return s.substring(minLow, minTop + 1);
        }
        else return "";
    }
}