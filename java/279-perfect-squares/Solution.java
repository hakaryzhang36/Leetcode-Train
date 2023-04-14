// Leetcode 279-perfect-squares
class Solution {
    List<Integer> list = new ArrayList<>();
    public int numSquares(int n) {
        for (int i = 1; i*i <= n; i++) list.add(i*i);
        if (list.contains(n)) return 1;
        int[] c = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) {
                c[i] = 1;
                continue;
            }
            c[i] = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                c[i] = Math.min(c[i], 1 + c[i-j*j]);
            }
        }

        return c[n];

    }

}