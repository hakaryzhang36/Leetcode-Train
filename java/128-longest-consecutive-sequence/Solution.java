// Leetcode 128-longest-consecutive-sequence
class Solution {
    public int longestConsecutive(int[] nums) {
        // (num, length)
        class Marker {
            int start;
            int end;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            // if num in map, skip
            if (map.containsKey(num)) continue;

            // new point, get new length by left and right point (if existed)
            int length = 1;
            length += map.getOrDefault(num + 1, 0);
            length += map.getOrDefault(num - 1, 0);
            map.put(num, length);
            
            // update the margin, start & end
            // ensure the margin point has the real length
            if (map.containsKey(num+1)) {
                map.put( (num+1) + (Integer)map.get(num+1) - 1, length);
            }
            if (map.containsKey(num-1)) {
                map.put( (num-1) - (Integer)map.get(num-1) + 1, length);
            }

            ans = Math.max(ans, length);
        }
        return ans;
    }
}