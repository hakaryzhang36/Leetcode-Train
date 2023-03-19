// Leetcode 415-add-strings
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }

        String res = "";
        int i = num1.length()-1;
        int j = num2.length()-1;
        int up = 0;
        while (j >= 0) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            int r = a+b+up;
            up = 0;
            if (r > 9) {
                up = 1;
                r -= 10;
            }
            res = String.valueOf(r) + res;
            i--;
            j--;
        }

        while (i >= 0 && up == 1) {
            int a = num1.charAt(i) - '0';
            int r = a+up;
            up = 0;
            if (r > 9) {
                up = 1;
                r -= 10;
            }
            res = String.valueOf(r) + res;
            i--;
        }

        if (i >= 0) {
            res = num1.substring(0, i+1) + res;
        }
        if (up == 1) {
            res = "1" + res;
        }
        return res;
        
    }
}