#include <iostream>
#include <vector>
using namespace std;

bool isMedian(int n, double& mid, int totalLen, int k) {
    bool isOdd = totalLen % 2 ? true : false;
    if (isOdd && k == totalLen / 2 + 1) {   // 奇数的情况，直接到中位数的位置就可以了
        mid = n;
        return true;
    }
    if (!isOdd) {                           // 偶数的情况，复杂一点
        if (k == totalLen / 2) {
            mid += n;
            return false;
        }
        if (k == totalLen / 2 + 1) {
            mid = (mid + n) / 2;
            return true;
        }
    }
    return false;
};

class Solution {
   public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int totalLen = nums1.size() + nums2.size();
        double mid = 0;
        for (int i = 0, j = 0, k = 0; i < nums1.size() || j < nums2.size();) {
            if (i < nums1.size() && j < nums2.size()) {
                if (nums1[i] < nums2[j]) {
                    k++;
                    if (isMedian(nums1[i], mid, totalLen, k))
                        break;
                    i++;
                } else {
                    k++;
                    if (isMedian(nums2[j], mid, totalLen, k))
                        break;
                    j++;
                }
            }
            if (i == nums1.size()) {    // nums1遍历完了
                k++;
                if (isMedian(nums2[j], mid, totalLen, k))
                    break;
                j++;
            }
            if (j == nums2.size()) {    // nums2遍历完了
                k++;
                if (isMedian(nums1[i], mid, totalLen, k))
                    break;
                i++;
            }
        }
        return mid;
    }
};
