#include <string>
#include <iostream>

using namespace std;

class Solution {
   public:
    int reverse(int x) {
        int ans = 0;
        string str = "";
        // 反转绝对值x写入字符串s
        for (int m = 10, t = x; t != 0;) {
            str.push_back((char)(abs(t % m) + '0'));
            t /= m;
        }
        string max = "2147483647", min = "2147483648";
        bool check = true;      // 是否需要判断溢出
        // s转化为整型，并判断是否溢出
        for (int i = 0; i < str.size(); i++) {
            if(str.size() > max.size()){
                return 0;
            }
            if (str.size() < max.size()) {
                check = false;
            }
            if (x > 0) {
                if (check && str[i] > max[i])
                    return 0;
                if (check && str[i] < max[i])
                    check = false;
                ans = ans * 10 + (int)(str[i] - 48);
            } else {
                if (check && str[i] > min[i])
                    return 0;
                if (check && str[i] < min[i])
                    check = false;
                ans = ans * 10 - (int)(str[i] - 48);
            }
        }
        return ans;
    }
};

int main(){
    int x = -2147483648;
    cout << (new Solution)->reverse(x) << endl;
}