#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution {
    public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int a = NULL, b = NULL;
        vector<int> nums_o = nums;
        // 排序复杂度O（nlogn）
        sort(nums.begin(), nums.end());
        // 头尾双指针，复杂度O（n）
        int i = 0, j = nums.size() - 1;
        do {
            if (nums[i] + nums[j] == target) {
                for (int k = 0; k < nums_o.size(); k++) {
                    if (nums_o[k] == nums[i] || nums_o[k] == nums[j]){
                        if(a == NULL)
                            a = k;
                        else{
                            b = k;
                            break;
                        }
                    }
                }
                break;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }
        } while (i != j);
        return {a, b};
    }
};

int main(){
    vector<int> nums = {2, 7, 11, 15};
    int target = 9;
    Solution s;
    vector<int> ans = s.twoSum(nums, target);
    cout << ans[0] << ans[1];
}