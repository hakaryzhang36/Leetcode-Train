// Leetcode 49-group-anagrams
// mark
// done
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int[] count = new int[26];
        boolean[] mark = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (mark[i]) {
                continue;
            }
            else {
                mark[i] = true;
                List<String> pattern = new ArrayList<>();
                pattern.add(strs[i]);
                
                count = new int[26];
                for (int j = 0; j < strs[i].length(); j++) {
                    count[strs[i].charAt(j) - 'a']++;
                }

                for (int k = i+1; k < strs.length; k++) {
                    if (mark[k] || strs[k].length() != strs[i].length()) {
                        continue;
                    }
                    else {
                        int[] cheak = new int[26];
                        boolean isMatch = true;
                        for (int ki = 0; ki < strs[k].length(); ki++) {
                            if (++cheak[strs[k].charAt(ki)-'a'] > count[strs[k].charAt(ki)-'a']) {
                                isMatch = false;
                                break;
                            }
                        }
                        if (isMatch) {
                            mark[k] = true;
                            pattern.add(strs[k]);
                        }
                    }
                }

                ans.add(pattern);
            }
        }
        return ans;
    }
}