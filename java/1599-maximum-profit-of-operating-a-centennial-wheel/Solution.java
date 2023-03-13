// Leetcode 1599-maximum-profit-of-operating-a-centennial-wheel
// mark
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        // Scanner in = new Scanner();
        // String customers = in.nextLine();
        // String boardingCost = in.nextLine();

        // 第 i 天前 到达的总人数
        // int[] up = new int[customers.length];

        // 第 i 天前 总人数
        int total = customers[0];

        // 转到第 i 天的利润
        int[] profit = new int[customers.length+4];

        for (int i = 4; i < customers.length+4; i++) {
            profit[i] = (total * boardingCost) - (i * runningCost); 
            total += customers[i-3];
        }
        int max = -1;
        for (int i = 4; i < profit.length; i++) {
            max = Math.max(profit[i], max);
        }
        return max;
    }
}