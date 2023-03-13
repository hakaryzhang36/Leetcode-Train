// Leetcode 135-candy
// marked
// AMAZING IDEA!
class Solution {
    int ansf = 0;
    public int candy(int[] ratings) {
        Map<Integer, List<Integer>> score2childs = new TreeMap<>();
        for (int i = 0; i < ratings.length; i++) {
            List<Integer> list = score2childs.getOrDefault(ratings[i], new ArrayList<Integer>());
            list.add(i);
            score2childs.put(ratings[i], list);
        }


        int[] give = new int[ratings.length];
        int candies = 0;
        for (Map.Entry<Integer, List<Integer>> e : score2childs.entrySet()) {
            int s = e.getKey();
            List<Integer> list = e.getValue();
            // give candy
            for (Integer i : list) {
                int c = 1;
                if (i-1 >= 0 && ratings[i-1]<s) {
                    c = Math.max(give[i-1]+1, c);
                }
                if (i+1 < ratings.length && ratings[i+1]<s) {
                    c = Math.max(give[i+1]+1, c);
                }
                give[i] = c;
                candies += c;
            }
        }

        return candies;
    }

}