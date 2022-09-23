// Leetcode 844
// mark
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sBack = 0, tBack = 0;
        char sHead = '#', tHead = '#';
        for (int si = s.length() - 1, ti = t.length() - 1; si > -1 || ti > -1; si--, ti--) {
            while (si > -1) {
                if ('#' == s.charAt(si)) {
                    sBack++;
                }
                else if (sBack > 0) {
                    sBack--;
                }
                else {
                    break;
                }
                si--;
            }
            if (si > -1) {
                sHead = s.charAt(si);
            }
            else {
                sHead = '#';
            }
            System.out.println(sHead);

            while (ti > -1) {
                if ('#' == t.charAt(ti)) {
                    tBack++;
                }
                else if (tBack > 0) {
                    tBack--;
                }
                else {
                    break;
                }
                ti--;
            }
            if (ti > -1) {
                tHead = t.charAt(ti);
            }
            else {
                tHead = '#';
            }

            System.out.println(tHead);

            // compare
            if (sHead != tHead){
                return false;
            }
        }
        return true;
    }
}