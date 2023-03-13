// Leetcode 347-top-k-frequent-elements
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        // count the times of each nums
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] list = new int[map.size()];
        int i = 0;
        for (Integer n : map.keySet()) {
            list[i] = n;
            i++;
        }

        quickSort(0, list.length-1, list);
        
        int[] ans = new int[k];
        for (int ki = 0; ki < k; ki++) {
            ans[ki] = list[list.length-1-ki];
        }
        return ans;
    }

    private void quickSort(int l, int r, int[] nums) {
        int val = nums[r];
        int i = l-1;
        int j = l;
        while (j < r) {
            if (map.get(nums[j]) < map.get(val)) {
                i+=1;
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
            j++;
        }
        int p = i+1;
        nums[r] = nums[p];
        nums[p] = val;
        if (l < p-1) {
            quickSort(l, p-1, nums);
        }
        if (p+1 < r) {
            quickSort(p+1, r, nums);
        }
    }
}