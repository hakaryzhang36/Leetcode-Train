#include <iostream>
#include <vector>
using namespace std;

// 双指针
class Solution {
   public:
    int maxArea(vector<int>& height) { 
        int max = 0;
        for (int i = 0, j = height.size() - 1; i != j;){
            int low = height[i] < height[j] ? height[i] : height[j];
            if (max < low * (j - i)) {
                max = low * (j - i);
            }
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
};

int main() {
    vector<int> height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    cout << (new Solution)->maxArea(height) << endl;
}