#include <algorithm>
#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

class Solution {
   public:
    int lengthOfLongestSubstring(string s) {
        map<char, int> m;
        int maxLen = 0, len = 0;
        for (int head = 0, tail = 0; tail < s.length(); tail++) {
            if (m.find(s[tail]) == m.end()) {   // 没有重复
                m[s[tail]] = tail;              // 将tail元素写入map
                len++;
            }
            else{                               // 出现重复
                int temp = m[s[tail]];          // 重要！要保证head移动到相同元素的下一位置
                while (head <= temp) {          // head向前移动，删除map中元素
                    m.erase(s[head]);
                    head++;
                }
                m[s[tail]] = tail;              // 将tail元素写入map
                len = tail - head + 1;
            }
            maxLen = max(maxLen, len);
        }
        return maxLen;
    }
};

int main(){
    string s = "pwwkew";
    Solution sol;
    cout << sol.lengthOfLongestSubstring(s) << endl;
}