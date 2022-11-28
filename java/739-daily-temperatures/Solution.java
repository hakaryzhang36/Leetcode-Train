// Leetcode 739-daily-temperatures
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < temperatures.length; i++) {
            while (stack.size() != 0 && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        // stack 最多还有一个元素
        res[stack.getLast()] = 0;
        return res;
    }
}