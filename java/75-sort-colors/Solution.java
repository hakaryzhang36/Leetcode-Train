// Leetcode 75-sort-colors
class Solution {
    public void sortColors(int[] nums) {
        int s1 = -1, s2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if (s1 == -1 && s2 == -1) {
                    continue;
                }
                if (s1 == -1 && s2 != -1) {
                    nums[s2] = 0;
                    nums[i] = 2;
                    s2++;
                }
                if (s1 != -1 && s2 == -1) {
                    nums[s1] = 0;
                    nums[i] = 1;
                    s1++;
                }
                if (s1 != -1 && s2 != -1) {
                    nums[s1] = 0;
                    nums[s2] = 1;
                    nums[i] = 2;
                    s1++;
                    s2++;
                }
            }

            if (nums[i] == 1) {
                if (s2 != -1) {
                    nums[s2] = 1;
                    nums[i] = 2;
                    s2++;
                    if(s1 == -1) {
                        s1 = s2 - 1;
                    }
                }
                else if (s1 == -1) {
                    s1 = i;
                }
            }

            if (nums[i] == 2) {
                if (s2 == -1) {
                    s2 = i;
                }
            }

        }
    }
}