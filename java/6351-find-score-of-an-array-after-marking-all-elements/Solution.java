// Leetcode 6351-find-score-of-an-array-after-marking-all-elements
class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    if (nums[a] != nums[b]) {
                        return nums[a] - nums[b];
                    }
                    else {
                        return a-b;
                    }
                }
            }
        );

        for (int i = 0; i < nums.length; i++) {
            q.offer(i);
        }

        boolean[] mark = new boolean[nums.length];
        long score = 0;

        while (!q.isEmpty()) {
            int i = q.poll();
            if (!mark[i]) {
                score += (long)nums[i];
                mark[i] = true;
                if (i-1>=0) {
                    mark[i-1] = true;
                }
                if (i+1<nums.length) {
                    mark[i+1] = true;
                }
            }
        }

        return score;

    }
}