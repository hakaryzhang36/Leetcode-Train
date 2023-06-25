// Leetcode 46-permutations
class Solution {
    List<List<Integer>> r = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        sub(new ArrayList<Integer>(), nums, new boolean[nums.length]);

        return r;
    }

    public void sub(ArrayList<Integer> l, int[] nums, boolean[] m) {
        for (int i = 0; i < nums.length; i++) {
            if(!m[i]) {
                m[i] = true;
                l.add(nums[i]);
                if(l.size() < nums.length) {
                    sub(l, nums, m);
                }
                else {
                    r.add((List<Integer>)l.clone());
                }
                m[i] = false;
                l.remove(l.size()-1);
            }
        }
    }
}