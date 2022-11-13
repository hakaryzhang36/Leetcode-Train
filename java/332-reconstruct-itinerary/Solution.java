// Leetcode 332-reconstruct-itinerary
class Solution {
    Map<String, TreeMap<String, Integer>> departures = new HashMap<>();
    int pathLength;
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        pathLength = tickets.size() + 1;

        // 遍历 tickets
        for (List<String> ticket : tickets) {
            String dest = ticket.get(1);
            String dept = ticket.get(0);
            // 获取始发地可达目的地的 TreeMap，有序
            TreeMap<String, Integer> destTickets = departures.getOrDefault(dept, 
                new TreeMap<String, Integer>(
                        new Comparator<String>() {
                            public int compare(String obj1, String obj2) {
                                return obj1.compareTo(obj2);
                            }
                        }
            ));

            // 加入/更新 目的地，到目的地的票子 + 1
            destTickets.put(dest, destTickets.getOrDefault(dest, 0) + 1);

            // 更新始发站
            departures.put(dept, destTickets);
        }

        reverse(new LinkedList<String>());
        return res;
    }

    private boolean reverse(LinkedList<String> path) {
        
        // 所有票子用完，找到符合要求的行程了
        if (path.size() == pathLength) {
            res = path;
            return true;
        }
        // start at JFK
        if (path.size() == 0) {
            path.add("JFK");
            reverse(path);
        }
        else {
            TreeMap<String, Integer> destTickets = departures.getOrDefault(path.getLast(), null);
            // 没有下一站
            if (destTickets == null) {
                return false;
            }
            // 选择下一站
            for (String dest : destTickets.keySet()) {
                Integer count = destTickets.get(dest);
                if (count > 0) {
                    // 票子减一，应该Entity是引用类型，可以直接修改吧
                    destTickets.put(dest, count - 1);
                    path.add(dest);
                    if (reverse(path)) {
                        // 行程已确定，返回
                        return true;
                    }
                    path.removeLast();
                    // 票子撤回
                    destTickets.put(dest, count);
                }
            }
        }
        // all of path fail
        return false;
    }
}