// Leetcode 440-k-th-smallest-in-lexicographical-order
// mark
class Solution {
    int ans = 0;
    int n = 0;
    int nLen = 0;
    public int findKthNumber(int n, int k) {
        this.n = (long)n;
        int t = 0;
        while (n != 0) {
            n /= 10;
            t++;
        }
        this.nLen = t;
        sub(1, 1, k);
        return ans;
    }


    // 返回在 num 后生成了多少位
    public int sub(long pre, int prelen, int k) {
        // k 表示在这个前缀下，找到后面第 k 个数
        for (int i = 0; i <= 9 && no < k; i++) {
            long newNum = 0;

            // 计算以 pre 为前缀的数有多少个
            int count = 0;
            for (int i = 1; i <= nLen-prelen; i++) {
                count = count*10 + 10;
            }
            

            // 检查第 k 个数是否在 max 是否
        }
        return no;
    }
}