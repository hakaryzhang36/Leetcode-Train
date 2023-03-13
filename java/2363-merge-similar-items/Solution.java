// Leetcode 2363-merge-similar-items
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new LinkedList<>();
        ret.add(Arrays.asList(items1[0][0], items1[0][1]));

        for (int i = 1; i < items1.length + items2.length; i++) {
            int v = i<items1.length ? items1[i][0] : items2[i-items1.length][0];
            int w = i<items1.length ? items1[i][1] : items2[i-items1.length][1];
            int p = 0;
            while (p <= ret.size()) {
                if (p == ret.size()) {
                    ret.add(Arrays.asList(v, w));
                    break;
                }
                if (v < ret.get(p).get(0)){
                    ret.add(p, Arrays.asList(v, w));
                    break;
                }
                if (v == ret.get(p).get(0)){
                    ret.get(p).set(1, ret.get(p).get(1)+w);
                    break;
                }
                p++;
            }
        }
        return ret;
    }
}