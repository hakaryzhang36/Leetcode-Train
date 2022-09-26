#include<string>
#include<iostream>
using namespace std;

#define MAX_NUM 2147483647
#define MIN_NUM -2147483648

class Solution {
   public:
    int myAtoi(string s) {
        int ans = 0;
        bool isNum = false;
        bool isNeg = false;
        for (int i = 0; i < s.size(); i++) {
            if (!isNum && (s[i] == '+' || s[i] == '-')) {
                isNum = true;
                if (s[i] == '-') {
                    isNeg = true;
                }
                continue;
            }
            if (!isNum && s[i] == ' ') {
                continue;
            }
            if (s[i] >= '0' && s[i] <= '9') {
                isNum = true;
                // 判断溢出
                if (ans > 214748364 || (ans == 214748364 && s[i] > '7')) {
                    return MAX_NUM;
                }
                if (ans < -214748364 || (ans == -214748364 && s[i] > '8')) {
                    return MIN_NUM;
                }
                // 计算结果
                if (!isNeg) {
                    ans = ans * 10 + (s[i] - '0');
                } else {
                    ans = ans * 10 - (s[i] - '0');
                }
            } else {    // 其他字符返回
                break;
            }
        }
        return ans;
    }
};

