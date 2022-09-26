#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
   public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* ans = new ListNode;
        ListNode* t = ans;
        int carry = 0;
        while (l1 != nullptr || l2 != nullptr) {
            if (l1 == nullptr) {
                t->next = new ListNode((l2->val + carry) % 10);
                carry = (l2->val + carry) / 10;
                t = t->next;
                l2 = l2->next;
                continue;
            }
            if (l2 == nullptr) {
                t->next = new ListNode((l1->val + carry) % 10);
                carry = (l1->val + carry) / 10;
                t = t->next;
                l1 = l1->next;
                continue;
            }
            if (l1 != nullptr && l2 != nullptr) {
                t->next = new ListNode((l1->val + l2->val + carry) % 10);
                carry = (l1->val + l2->val + carry) / 10;
                t = t->next;
                l1 = l1->next;
                l2 = l2->next;
            }
        }
        if (carry != 0) {
            t->next = new ListNode;
            t = t->next;
            t->val = carry;
        }
        return ans->next;
    }
};


