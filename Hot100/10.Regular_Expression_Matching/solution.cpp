/**************************************
 *            NOT SUCCESS !           *
 **************************************/

#include <string>
#include <iostream>
using namespace std;

class Solution {
   public:
    bool isCharMatch(string s, string p, int& i, int& j) {
        while (j < p.size() && i < s.size()) {
            if (p[j] == s[i]) {
                j++, i++;
            } else if (p[j] == '*' || p[j] == '.') {
                return true;  // 遇到‘*’和‘.’，返回true，否则返回false
            } else {
                return false;  // 字母不匹配
            }
        }
        // s和p没有同时遍历完，即不匹配
        if (i == s.size() && j == p.size()) {
            return true;
        } else {
            return false;
        }
    };

    bool isStarMatch(string s, string p, int& i, int& j, char front) {
        bool isMore = j < p.size() - 1 ? true : false;  // ‘*’后面是否还有字符
        // 匹配判断
        while (i < s.size()) {
            if (s[i] == front || front == '.') {  // 匹配
                if (isMore) {  // ‘*’后面还有字符，则截取子串尝试匹配
                    if (isMatch(s.substr(i, s.size() - i), p.substr(j + 1, p.size() - j - 1))) {
                        return true;
                    }
                } else {
                    i++;
                }
            } else {  // 不匹配，返回子串 s[i:] 和 p[j + 1:] 匹配结果
                return isMatch(s.substr(i, s.size() - i), p.substr(j + 1, p.size() - j - 1));
            }
        }
        if(!isMore){
            return true;
        }
        else{
            return false;
        }
    };

    bool isMatch(string s, string p) {
        int i = 0;
        int j = 0;
        // 当前匹配串字符为字母
        if(p[j] >= 'a' && p[j] <= 'z'){
            if (!isCharMatch(s, p, i, j)) { 
                return false; 
            }
            else if(i == s.size() && j == p.size()){
                return true;
            }
        }
        // 当前匹配串字符为‘*’
        if (p[j] == '*') {
            return isStarMatch(s, p, i, j, p[j - 1]);
        }
        // 当前匹配串字符为‘.’,
        // 判断子串 s[i+1:] 和 p[j+1:] 的匹配结果
        if (p[j] == '.') {
            if(i == s.size() - 1 && j == p.size() - 1){
                return true;
            }
            if (i != s.size() - 1 && j == p.size() - 1) {
                return false;
            }
            if (i == s.size() - 1 && j != p.size() - 1) {
                return isMatch(s.substr(i, s.size() - i), p.substr(j + 1, p.size() - j - 1));
            }
            if (i != s.size() - 1 && j != p.size() - 1){
                return isMatch(s.substr(i + 1, s.size() - i - 1), p.substr(j + 1, p.size() - j - 1));
            }
        }
    };
};

int main(){
    string s = "aa", p = ".*";
    cout << (new Solution)->isMatch(s, p) << endl;

}