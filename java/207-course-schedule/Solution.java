// Leetcode 207-course-schedule
class Solution {
    Set<Integer> learned = new HashSet<>();
    int numCourses;
    int[][] prerequisites;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.prerequisites = prerequisites;
        return study(getUnableSet());
    }

    private boolean study(Set<Integer> unable) {
        // 如果上满了
        if (learned.size() == numCourses) {
            return true;
        }
        if (unable.size() + learned.size() == numCourses) {
            return false;
        }
        // 选一节课上
        for (int i = 0; i < numCourses; i++) {
            // 如果还没上，并且可以上
            if (!unable.contains(i) && !learned.contains(i)) {
                // 上课，更新不能上的课
                learned.add(i);
            }
        }
        return study(getUnableSet());
        // System.out.println("123");
    }

    private Set<Integer> getUnableSet() {
        Set<Integer> unable = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            // 如果 前置课还没学，加入 unable
            if (!learned.contains(prerequisites[i][1])) {
                unable.add(prerequisites[i][0]);
            }
        }
        return unable;
    }
}