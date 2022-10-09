// Leetcode 349-intersection-of-two-arrays
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        List<Integer> set = new ArrayList<Integer>();
        for (int i : nums1) {
            if (!set1.contains(i)){
                set1.add(i);
            }
        }
        for (int i : nums2) {
            if (!set2.contains(i)){
                set2.add(i);
            }
        }
        for (Integer i : set1) {
            if (set2.contains(i)) {
                set.add(i);
            }
        }
        int[] res = new int[set.size()];
        int k = 0;
        for (Integer i : set) {
            res[k] = i;
            k++;
        }
        return res;
    }
}