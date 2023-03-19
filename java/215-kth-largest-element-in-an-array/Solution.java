// Leetcode 215-kth-largest-element-in-an-array
// mark
// done
class Solution {
    int k;
    public int findKthLargest(int[] nums, int k) {
        this.k = nums.length - k + 1;
        return quickSort(nums, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int s, int e) {
        if (s > e) {
            return -1;
        }
        int i = s-1;
        int j = s;
        while (j < e) {
            if (nums[j] < nums[e]) {
                i++;
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
            j++;
        }
        i += 1;
        int t = nums[e];
        nums[e] = nums[i];
        nums[i] = t;
        if (i+1 == k) {
            return nums[i];
        }
        else if (i+1 > k) {
            return quickSort(nums, 0, i-1);
        }
        else {
            return quickSort(nums, i+1, e);
        }  
    }
}