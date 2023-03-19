// Leetcode 239-sliding-window-maximum
// mark
// AMAZING IDEA
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // New method
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int i = 0;
        int j = k-1;
        q.addLast(0);
        for (int t = 1; t <= j; t++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[t]) {
                q.pollLast();
            }
            q.addLast(t);
        }
        res[0] = nums[q.peekFirst()];

        for (i++, j++; j < nums.length; i++, j++) {
            // 检查最大值是否还在窗口内
            if (q.peekFirst() < i) {
                q.pollFirst();
            }
            // 把尾部元素加入队列
            while (!q.isEmpty() && nums[q.peekLast()] < nums[j]) {
                q.pollLast();
            }
            q.addLast(j);
            // 写入最大值
            res[i] = nums[q.peekFirst()];
        }

        return res;
    }
}