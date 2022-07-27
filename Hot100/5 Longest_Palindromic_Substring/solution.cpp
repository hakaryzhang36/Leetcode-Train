#include <string>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
   public:
    // 暴力解法，复杂度O(n^3)
    string longestPalindrome_1(string s) {
        string str = "";
        for (int head = 0, tail = 0; tail < s.size(); head++) {
            if(head > tail || tail - head + 1 < str.size()){
                tail++;
                head = -1;
                continue;
            }
            if (head == tail && str.size() < tail - head + 1) {  // 子串只有一个字符
                str = s.substr(head, 1);
                continue;
            }
            for (int i = head, j = tail; i - 1 <= j && s[i] == s[j]; i++, j--) {  // 子串不止一个字符,判断子串是否回文
                if(i == j && str.size() < tail - head + 1){
                    str = s.substr(head, tail - head + 1);
                }
                if (i - 1 == j && str.size() < tail - head + 1) {
                    str = s.substr(head, tail - head + 1);
                }
            }
        }
        return str;
    }

    // 动态规划，复杂度O(n^2)
    string longestPalindrome_2(string s) { 
        const int len = s.size();
        string str = s.substr(0, 1);
        vector<vector<bool>> P(len, vector<bool>(len));     // vector多维数组初始化
        for (int L = 1; L <= len; L++){
            for (int i = 0; i + L - 1 < len; i++){
                if(L == 1){     // 子串长度为1，直接true
                    P[i][i] = true;
                }
                if(L == 2){     // 子串长度为2
                    P[i][i + 1] = (s[i] == s[i + 1]);
                }
                if(L > 2){      // 子串长度大于2
                    P[i][i + L - 1] = (P[i + 1][i + L - 2] && s[i] == s[i + L - 1]);
                }
                if(P[i][i + L - 1] && str.size() < L){
                    str = s.substr(i, L);
                }
            }
        }
        return str;
    }
};

int main(){
    string s = "babad";
    cout << (new Solution)->longestPalindrome_2(s) << endl;
}