// Leetcode 912-sort-an-array
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int h, int e) {
        if (h >= e) return;
        int r = h + new Random().nextInt((e-h)+1);
        int pivot = nums[r];
        nums[r] = nums[e];
        nums[e] = pivot;

        int a = h-1, b = h;
        while(b < e) {
            if (nums[b] < pivot) {
                a++;
                int t = nums[b];
                nums[b] = nums[a];
                nums[a] = t;
            }
            b++;
        }
        a++;
        nums[e] = nums[a];
        nums[a] = pivot;
        quickSort(nums, h, a-1);
        quickSort(nums, a+1, e);
    }
}