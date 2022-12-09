// Leetcode 84-largest-rectangle-in-histogram
// mark
// 不用想了，直接看思路，这是要背的方法。
class Solution {
    public int largestRectangleArea(int[] heights) {

        // h[i] 的左边界
        int[] left = new int[heights.length];

        // 单调栈，只存储栈顶为最高
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        // 右边界是 pop 的时候确定的，因为 pop 的原因是右边到达了更矮的位置
        // 左边界是 push 的时候确定的，因为 push 时候栈顶一定是i左边第一个比i矮的。
        for (int i = 0; i < heights.length; i++) {
            int l = i;
            // 如果遍历到的高度比栈顶的矮，说明栈顶对应位置的右边界可以确定了，是当前位置i - 1，可以 pop 出计算面积。
            int right = i - 1;
            while (stack.size() != 0 && heights[i] < heights[stack.peek()]) {
                int pos = stack.pop();
                int wide = right - left[pos] + 1;
                // System.out.format("%d [%d, %d]\n", heights[pos], heights[left[pos]], heights[right]);
                res = Math.max(res, wide * heights[pos]);
            }

            // 左边界是 push 的时候确定的，因为 push 时候栈顶一定是i左边第一个比i矮的。
            left[i] = stack.size() == 0 ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        if (stack.size() > 0) {
            int right = stack.peek();
            while (stack.size() > 0) {
                int pos = stack.pop();
                int wide = right - left[pos] + 1;
                res = Math.max(res, wide * heights[pos]);
            }
        }
        return res;
    }
}