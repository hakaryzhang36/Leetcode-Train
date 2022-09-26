#include <vector>
#include <iostream>
using namespace std;

// 动态规划，时间复杂度O（n^2）
class Solution {
   public:
    int maxArea(vector<int>& height) {
        int n = height.size();
        vector<vector<int>> V(n, vector<int>(n));
        for (int w = 1; w < n; w++){    // 容器宽度从1开始增长
            if(w == 1){                 // 当宽度为1时，初始化V[1]
                for (int i = 0; i < n - 1; i++){
                    int low =
                        height[i] < height[i + 1] ? height[i] : height[i + 1];
                    V[1][i] = low * 1;
                }
            }
            else{
                for (int i = 0; i + w < n; i++) {
                    int v1 = V[w - 1][i] > V[w - 1][i + 1] ? V[w - 1][i] : V[w - 1][i + 1];     // v1为 i 和 i+1 为左璧，宽度为 w-1 的容器中的容积较大值
                    int low =
                        height[i] < height[i + w] ? height[i] : height[i + w];
                    int v2 = low * w;                                                           // v2为以 i 为左璧，宽度为 w 的容器的容积
                    V[w][i] = v1 > v2 ? v1 : v2;
                }
            }
        }
        return V[n - 1][0];
    }
};

int main(){
    vector<int> height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    cout << (new Solution)->maxArea(height) << endl;
}