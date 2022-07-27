#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
   public:
    string convert(string s, int numRows) {
        string str = "";
        vector<string> subStrs(numRows);
        bool isF = true;
        int r = 0, i = 0;
        for (; i < s.size(); i++) {
            subStrs[r] += s[i];
            if (r == numRows - 1) {
                isF = false;
            }
            if (r == 0) {
                isF = true;
            }
            if (numRows != 1){
                isF ? r++ : r--;
            }
        }
        for (int r = 0; r < numRows; r++) {
            str += subStrs[r];
        }
        return str;
    }
};

int main() {
    string s = "AB";
    int numRows = 1;
    cout << (new Solution)->convert(s, numRows) << endl;
}