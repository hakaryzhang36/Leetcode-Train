// Leetcode 6323-distribute-money-to-maximum-children
class Solution {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        money = money - children;
        int count = 0;
        for (int i = 1; i <= children; i++) {
            if (money >= 7) {
                count++;
                money-=7;
            }
            else if (money != 3){
                return count;
            }
            else if (money == 3 && i+1 <= children){
                return count;
            }
            else {
                return count-1;
            }
        }
        if (money > 0) {
            return count-1;
        }
        return count;
    }
}