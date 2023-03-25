// Leetcode 540-single-element-in-a-sorted-array
class Solution {
    int[] nums = null;
    int ans;
    public int singleNonDuplicate(int[] nums) {
        this.nums = nums;
        sub(0, nums.length-1);
        return ans;
    }

    
    public void sub(int L, int R) {
        if (L >= R) {
            ans = nums[L];
            return;
        }
        int mid = (L + R)/2;
        // compare
        boolean b1 = false, b2 = false;
        if (mid-1 >= 0) {
            b1 = nums[mid] == nums[mid-1];
        }
        if (mid+1 < nums.length) {
            b2 = nums[mid] == nums[mid+1];
        }
        // result
        if (!b1 && !b2) {
            ans = nums[mid];
        }
        else {
            // 左右边界
            int k1, k2;
            if (b1) {
                k1 = mid-2;
                k2 = mid+1;
            }
            else {
                k1 = mid-1;
                k2 = mid+2;
            }
            // 向下查找
            if (L <= k1 && (k1-L+1)%2 == 1) {
                sub(L, k1);
            }
            else {
                sub(k2, R);
            }
        }
    }
}