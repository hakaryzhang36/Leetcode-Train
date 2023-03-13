// Leetcode 34-find-first-and-last-position-of-element-in-sorted-array
class Solution {
    int[] nums;
    int target;
    int[] res = {-1, -1};
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        fc(0, nums.length - 1);
        return res;
    }

    private void fc(int l, int r) {
        if (l <= r) {
            // case 1
            if (l == r) {
                if (nums[l] == target) {
                    updateRes(l);
                }
                return;
            }

            int mid = (l + r) / 2;
            // case 2
            if (nums[mid] == target) {
                updateRes(mid);
                if (mid - 1 >= l && nums[mid-1] == target) {
                    fc(l, mid-1);
                }
                if (mid + 1 <= r && nums[mid+1] == target) {
                    fc(mid+1, r);
                }
            }
            
            // case 3: find in left
            if(nums[mid] > target) {
                fc(l, mid-1);
            }

            // case 4: find in right
            if(nums[mid] < target) {
                fc(mid+1, r);
            }
        }
    }

    private void updateRes(int i) {
        if (res[0] == -1) res[0] = i;
        if (res[1] == -1) res[1] = i;
        res[0] = Math.min(res[0], i);
        res[1] = Math.max(res[1], i);
    }
}