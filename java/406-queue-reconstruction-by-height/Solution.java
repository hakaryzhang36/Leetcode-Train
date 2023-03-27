// Leetcode 406-queue-reconstruction-by-height
// mark
// done
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                else {
                    return a[1] - b[1];
                }
            }
        });

        for (int i = people.length-1; i >= 0; i--) {
            int e = 0;  // 前面有几个相等的
            int m = i-1;
            while (m >= 0 && people[i][0] == people[m][0]) {
                m--;
                e++;
            }
            while (i > m) {
                sub(i, e, people);
                i--;
                e--;
            }
            i = m+1;
        }

        return people;
    }

    public void sub(int m, int e, int[][] people) {
        while (people[m][1] > e) {
            int[] temp = people[m];
            people[m] = people[m+1];
            people[m+1] = temp;
            e++;
            m++;
        }
    }
}