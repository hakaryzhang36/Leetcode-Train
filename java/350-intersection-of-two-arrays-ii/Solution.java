// Leetcode 350-intersection-of-two-arrays-ii
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> set1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> set2 = new HashMap<Integer, Integer>();
        for (Integer i : nums1) {
            if (!set1.containsKey(i)){
                set1.put(i, 1);
            }
            else {
                Integer k = set1.get(i) + 1;
                set1.remove(i);
                set1.put(i, k);
            }
        }
        for (int i : nums2) {
            if (!set2.containsKey(i)){
                set2.put(i, 1);
            }
            else {
                Integer k = set2.get(i) + 1;
                set2.remove(i);
                set2.put(i, k);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (HashMap.Entry<Integer, Integer> e : set1.entrySet()) {
            if (set2.containsKey(e.getKey())) {
                for (int i = 0; i < Math.min(e.getValue(), set2.get(e.getKey())); i++) {
                    list.add(e.getKey());
                }
            }
        }
        
        int[] res = new int[list.size()];
        int k = 0;
        for (Integer i : list) {
            res[k] = i;
            k++;
        }
        return res;
    }
}