// Leetcode 165-compare-version-numbers
class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < version1.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (i < version1.length() && version1.charAt(i) != '.') {
                sb.append(version1.charAt(i));
                i++;
            }
            l1.add(Integer.parseInt(sb.toString()));
        }
        for (int i = 0; i < version2.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (i < version2.length() && version2.charAt(i) != '.') {
                sb.append(version2.charAt(i));
                i++;
            }
            l2.add(Integer.parseInt(sb.toString()));
        }


        for (int i = 0, j = 0; i < l1.size() || j < l2.size(); i++, j++) {
            if (i>=l1.size()) {
                if (l2.get(j) < 0) {
                    return 1;
                }
                else if (l2.get(j) > 0) {
                    return -1;
                }
            }
            else if (j>=l2.size()) {
                if (l1.get(i) < 0) {
                    return -1;
                }
                else if (l1.get(i) > 0) {
                    return 1;
                }
            }
            else {
                if (l1.get(i) > l2.get(j)) {
                    return 1;
                }
                else if (l1.get(i) < l2.get(j)) {
                    return -1;
                }
            }
        }
        return 0;
    }
}