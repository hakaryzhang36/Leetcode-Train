// Leetcode 43-multiply-strings
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num2.length()-1; i >= 0; i--) {
            int up = 0; // 进位
            int pos = ans.length - 1 - (num2.length()-1-i);   // 加法起始位置
            for (int j = num1.length()-1; j >= 0; j--, pos--) {
                int a = num1.charAt(j) - '0';
                int b = num2.charAt(i) - '0';
                int t = a * b + ans[pos] + up;
                if (t >= 10) {
                    up = t / 10;
                    t = t - 10*up;
                }
                else {
                    up = 0;
                }
                ans[pos] = t;
            }
            if (up != 0) {
                ans[pos] += up;
            }
        }

        // final
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < ans.length && ans[i] == 0) {
            i++;
        }
        while (i < ans.length) {
            sb.append(ans[i]);
            i++;
        }

        return sb.toString();
    }
}


