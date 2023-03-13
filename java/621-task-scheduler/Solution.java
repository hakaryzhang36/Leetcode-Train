// Leetcode 621-task-scheduler
// mark
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int time = 0;
        int left = map.size();
        int i = 1;
        Character[] chs = map.keySet().toArray(new Character[map.size()]);
        int k = 0;
        while (left > 0) {
            while (i < n+1 && left > 0){
                // skip
                if (map.get(chs[k]) == 0) {
                    k++;
                    // keep loop of key list
                    if (k == chs.length - 1) {
                        k = -1;
                    }
                    continue;
                }
                
                // update left
                map.put(chs[k], map.get(chs[k])-1);
                if (map.get(chs[k]) == 0) {
                    left--;
                    System.out.println(chs[k]);
                }

                // keep loop of key list
                if (k == chs.length - 1) {
                    k = -1;
                }
                k++;
                i++;
            }
            // 更新时间
            if (left > 0) {
                time += n;
            }
            else {
                time += i-1;
            }
        }
        return time;
    }
}