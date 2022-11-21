// Leetcode 56-merge-intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < intervals.length; i++) {
            if (map.containsKey(intervals[i][0])) {
                if (map.get(intervals[i][0]) < intervals[i][1]) {
                    map.put(intervals[i][0], intervals[i][1]);
                }
            }
            else {
                map.put(intervals[i][0], intervals[i][1]);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            list.add(e);
        }


        for(int i = 0; i < list.size(); i++) {
            Integer s = list.get(i).getKey();
            Integer e = list.get(i).getValue();
            for (int k = i+1; k < list.size() && list.get(k).getKey() <= e;){
                if (list.get(k).getValue() > e) {
                    e = list.get(k).getValue();
                }
                list.get(i).setValue(e);
                list.remove(k);
            }
        }


        int[][] res = new int[list.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> e : list) {
            res[i][0] = e.getKey();
            res[i][1] = e.getValue();
            i++;
        }

        return res;
    }
}