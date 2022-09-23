// Leetcode 904
public class Solution {
    public int totalFruit(int[] fruits) {
        int type1 = -1, type2 = -1;
        int basket1 = 0, basket2 = 0;
        int maxTotal = 0;
        // move top
        for (int low = 0, top = 0; top < fruits.length; top++){
            if (type1 == -1 || type1 == fruits[top]) {
                type1 = fruits[top];
                basket1++;
                maxTotal = Math.max(maxTotal, basket1 + basket2);
                continue;
            }
            if (type2 == -1 || type2 == fruits[top]) {
                type2 = fruits[top];
                basket2++;
                maxTotal = Math.max(maxTotal, basket1 + basket2);
                continue;
            }
            // new type
            // move low
            while (basket1 != 0 && basket2 != 0) {
                if (fruits[low] == type1) {
                    basket1--;
                }
                else {
                    basket2--;
                }
                low++;
            }
            // put in empty basket
            if (basket1 == 0) {
                type1 = fruits[top];
                basket1++;
            }
            else {
                type2 = fruits[top];
                basket2++;
            }
            maxTotal = Math.max(maxTotal, basket1 + basket2);
        }
        return maxTotal;
    }
}