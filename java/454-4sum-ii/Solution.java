// Leetcode 454-4sum-ii
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        class Combination {
            int first;
            int second;
            public Combination(int f, int s) {
                this.first = f;
                this.second = s;
            }
        }

        // create map
        Map<Integer, List<Combination>> map = new HashMap<Integer, List<Combination>>();
        for (int i = 0; i < nums1.length; i++) {
            for (int k = 0; k < nums2.length; k++) {
                int num = nums1[i] + nums2[k];
                Combination c = new Combination(i, k); 
                if (map.containsKey(num)) {
                    List<Combination> l = map.get(num);
                    l.add(c);
                    map.put(num, l);
                }
                else {
                    List<Combination> l = new ArrayList<Combination>();
                    l.add(new Combination(i, k));
                    map.put(num, l);
                }
            }
        }

        // traverse nums3 and nums4
        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int k = 0; k < nums4.length; k++) {
                int num = -(nums3[i] + nums4[k]);
                if (map.containsKey(num)) {
                    res += map.get(num).size();
                }
            }
        }
        return res;
    }
}