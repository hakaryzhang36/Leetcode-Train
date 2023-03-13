// Leetcode 33-search-in-rotated-sorted-array
class Solution {
    int[] nums;
    int target;
    int res = -1;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        fc(0, nums.length - 1);
        return res;
    }

    private void fc(int l, int r) {
        if (l <= r) {
            int mid = (l + r)/2;
            // case 1
            if (nums[mid] == target) {
                res = mid;
                return;
            }

            // case 2
            if (nums[mid] > target) {
                fc(l, mid-1);
                if (nums[mid] > nums[r]) {
                    fc(mid+1, r);
                }
            }

            // case 3
            if (nums[mid] < target) {
                fc(mid+1, r);
                if (nums[mid] < nums[l]) {
                    fc(l, mid-1);
                }
            }
        }
    }
}