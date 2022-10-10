// Leetcode 202-happy-number
class Solution {
    public boolean isHappy(int n) {
        boolean[] check = new boolean[810];
        // mod
        while (n != 1) {
            int sum = 0;
            while(n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if (check[n] || n == 0) {
                return false;
            }
            check[n] = true;
        }
        return true;
    }
}