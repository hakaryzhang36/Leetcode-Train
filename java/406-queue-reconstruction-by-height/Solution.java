// Leetcode 406-queue-reconstruction-by-height
// mark
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        for (int i = 0; i < people.length; i++) {
            for (int j = i + 1; j < people.length; j++) {
                if (people[i][0] > people[j][0]) {
                    int[] temp = people[i];
                    people[i] = people[j];
                    people[j] = temp;
                }
                else if (people[i][0] == people[j][0] && people[i][1] > people[j][1]) {
                    int[] temp = people[i];
                    people[i] = people[j];
                    people[j] = temp;
                }
            }
        }

        for (int i = people.length-1; i >= 0; i--) {
            int 
        }
    }
}