// Leetcode 287-find-the-duplicate-number
// mark
// 先想清楚基础难度，进阶没想
class Solution {
    public int findDuplicate(int[] nums) {
        // 重复元素范围, 开区间
        int rangeTop = nums.length, rangeLow = 0;
        for (int pos = 0; pos < nums.length;) {
            int num = nums[pos];
            int left = 0, right = 0;
            for (int i = 0; i < nums.length; i++) {
                if (pos == i) continue;
                if (num == nums[i]) {
                    return num;
                }
                else if (num < nums[i]){
                    right++;
                }
                else {
                    left++;
                }
            }
            // 更新重复元素范围
            if (left < num) {
                // 重复的元素比 num 大
                rangeLow = num;
            }
            else {
                // 重复的元素比 num 小
                rangeTop = num;
            }
            // 确定下一个候选元素位置
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > rangeLow && nums[i] < rangeTop) {
                    pos = i;
                    break;
                }
            }
        }
        // 不可能到达，到达就错了
        return -1;
    }
}