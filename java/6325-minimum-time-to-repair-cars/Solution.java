// Leetcode 6325-minimum-time-to-repair-cars
// mark
class Solution {
    public long repairCars(int[] ranks, int cars) {
        // id, count
        int[] fixedCount = new int[ranks.length];
        PriorityQueue<Integer> q = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    // 多修一辆增加的时间
                    long t1 = ranks[a] * ((long)fixedCount[a]+1)*((long)fixedCount[a]+1);
                    long t2 = ranks[b] * ((long)fixedCount[b]+1)*((long)fixedCount[b]+1);
                    if (t1 == t2) {
                        // 如果增加时间相等，rank小的优先
                        // 因为rank小，下一次增加的时间肯定小
                        // return ranks[a] - ranks[b];
                        return 0;
                    }
                    else {
                        return (t1 - t2)>0?1:-1;
                    }
                }
            }
        );

        for (int i = 0; i < ranks.length; i++) {
            q.offer(i);
        }

        long time = 0; 
        for (int i = 1; i <= cars; i++) {
            int id = q.poll();
            // System.out.println(id);
            long t = ranks[id] * ((long)fixedCount[id]+1)*((long)fixedCount[id]+1);
            if (time < t) {
                time = t;
            }
            fixedCount[id]++;
            q.offer(id);
        }
        return time;
    }
}