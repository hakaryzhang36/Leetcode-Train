// Leetcode 338-counting-bits
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int k = 1;
        for (int i = 1, j = 0; i < n + 1; i++, j++) {
            if (j + 1 > k) {
                j = 0;
                k = k * 2;
            }
            res[i] = res[j] + 1;
        }
        return res;
    }
}