// Leetcode 215-kth-largest-element-in-an-array
// mark
// done
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (a == b) return 0;
                else return a > b ? 1 : -1;
            }
        });

        for (int num : nums) {
            if (q.size() < k) {
                q.add(num);
            } else if (q.peek() < num) {
                q.poll();
                q.add(num);
            }
        }

        return q.peek();
    }
}