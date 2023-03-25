// Leetcode 621-task-scheduler
// mark
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] list = new int[26];
        int max = 0;
        for (char t : tasks) {
            list[t - 'A']++;
            max = Math.max(list[t - 'A'], max);
            // System.out.print(map.get(c));
        }
        int stot = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == max) {
                stot++;
            }
        }
        
        return Math.max(tasks.length, (max-1)*(n+1) + stot);
    }
}