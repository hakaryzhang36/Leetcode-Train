// Leetcode 229-majority-element-ii
// mark
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candA = nums[0], candB = nums[0];
        int countA = 0, countB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candA) {
                countA++;
                continue;
            }
            if (nums[i] == candB) {
                countB++;
                continue;
            }
            if (countA == 0) {
                candA = nums[i];
                countA = 1;
                continue;
            }
            else if (countB == 0) {
                candB = nums[i];
                countB = 1;
                continue;
            }
            
            countA--;
            countB--;
        }

        int cA = 0, cB = 0;
        for (int num : nums) {
            if (num == candA) {
                cA++;
            }
            if (num == candB) {
                cB++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (cA > nums.length / 3) {
            res.add(candA);
        }
        if (cB > nums.length / 3 && candA != candB) {
            res.add(candB);
        }
        return res;
    }
}