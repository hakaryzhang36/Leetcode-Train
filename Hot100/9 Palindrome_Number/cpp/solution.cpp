#include <string>
using namespace std;

class Solution {
   public:
    bool isPalindrome(int x) {
        string s;
        if(x < 0)
            return false;
        if(x == 0)
            return true;
        while (x != 0) {
            char ch = (char)(x % 10) - '0';
            s.push_back(ch);
            x /= 10;
        }
        for (int i = 0, j = s.size(); i < j; i++, j--){
            if(s[i] != s[j])
                return false;
        }
        return true;
    }
};