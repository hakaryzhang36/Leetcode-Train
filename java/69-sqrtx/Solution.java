// Leetcode 69-sqrtx
// mark
class Solution {
    public int mySqrt(int x) {
        // 
        // f = ans^2 - c
        // ans, ans^2 - c
        // f'= 2ans*x - ans^2 - c = 0
        if (x == 0) {
            return 0;
        }
        long c = x;
        long ans = x;
        while (ans * ans >= c) {
            long k = (ans + c/ans)/2;
            if (Math.abs(k-ans) < 1e-7) {
                return (int)k;
            }
            ans = k;
        }
        return (int)ans;
    }
}