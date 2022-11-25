// Leetcode offer-10
class Solution {
    int[] m = null;
    public int fib(int n) {
        m = new int[n + 1];
        return fib_sub(n);
    }

    public int fib_sub(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (m[n] != 0){
            return m[n];
        }
        else {
            m[n] = (fib_sub(n - 1) + fib_sub(n - 2)) % 1000000007;
            return m[n];
        }
    }
}