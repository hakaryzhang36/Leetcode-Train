// Leetcode 128-longest-consecutive-sequence
class Solution {
    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> len = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            // if num in map, skip
            if (len.containsKey(num)) continue;

            // new point, get new length by left and right point (if existed)
            int rightLength = len.getOrDefault(num + 1, 0);
            int leftLength = len.getOrDefault(num - 1, 0);
            len.put(num, 1 + rightLength + leftLength);

            int l = num - leftLength;
            int r = num + rightLength;
            len.put(l, 1 + rightLength + leftLength);
            len.put(r, 1 + rightLength + leftLength);

            ans = Math.max(ans, 1 + rightLength + leftLength);
        }
        return ans;
    }
}