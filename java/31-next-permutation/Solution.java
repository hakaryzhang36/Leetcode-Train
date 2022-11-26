// Leecode 31-next-permutation
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        for (int i = nums.length - 2, j = nums.length - 1; i >= 0; ) {
            if(nums[i] >= nums[j]) {
                i--;
                j--;
            }
            else {
                // 找到 i 后面比 i 大的最小值
                while (j < nums.length && nums[i] < nums[j]) {
                    j++;
                }
                j -= 1;
                // exchange
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // d = i + 1 到 k = end 翻转子数组，重排序
                for (int d = i + 1, k = nums.length - 1; d < k; k--, d++) {
                    int t = nums[d];
                    nums[d] = nums[k];
                    nums[k] = t;
                }
                return;
            }
        }
        // 当前数组字典排序最大
        // j 到 end 翻转子数组，重排序
        for (int j = 0, k = nums.length - 1; j < k; k--, j++) {
            int t = nums[j];
            nums[j] = nums[k];
            nums[k] = t;
        }
        return;
    }
}