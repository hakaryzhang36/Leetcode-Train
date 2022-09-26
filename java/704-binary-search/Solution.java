// Leetcode 704 
public class Solution {
    public int search(int[] nums, int target) {
            int low = 0, top = nums.length - 1;
            while (top - low >= 0) {
                int mid = (low + top) / 2;  // 取下界
                if (target == nums[mid]) {
                    return mid;
                }
                else if (target < nums[mid]) {
                    top = mid - 1;
                    continue;
                }
                else if (target > nums[mid]) {
                    low = mid + 1;
                }
            }
            return -1;
        }
}