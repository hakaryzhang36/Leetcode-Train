#include<iostream>
#include<string>
#include<map>
using namespace std;

map<char, int> valueSymbols = {
    {'I', 1},   {'V', 5},   {'X', 10},   {'L', 50},
    {'C', 100}, {'D', 500}, {'M', 1000},
};

class Solution {
   public:
    int romanToInt(string s) {
        int num = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            char c = s[i];
            if (c == 'I' || c == 'X' || c == 'C' && i + 1 < s.size()) {
                char t = s[i + 1];
                if (valueSymbols[c] < valueSymbols[t]) {
                    num -= valueSymbols[c];
                }
                else{
                    num += valueSymbols[c];
                }
            } else {
                num += valueSymbols[c];
            }
        }
        return num;
    }
};

int main(){
    string s = "III";
    cout << (new Solution)->romanToInt(s) << endl;
}