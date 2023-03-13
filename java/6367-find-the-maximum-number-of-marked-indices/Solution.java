// Leetcode 6367-find-the-maximum-number-of-marked-indices
// mark
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int markedfirst = 0;
        for (int i = nums.length - 1, j = (nums.length - 1)/2; j >= 0 && i > (nums.length - 1)/2;) {
            while (j >= 0 && 2 * nums[j] > nums[i]) {
                j--;
            }
            if (j < 0) {
                break;
            }
            else {
                j-=1;
                i-=1;
                ans++;
            }
        }
        return ans*2;
    }
}

// 1139