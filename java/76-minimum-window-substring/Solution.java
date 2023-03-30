// 76-minimum-window-substring
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> total = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            total.put(t.charAt(i), total.getOrDefault(t.charAt(i), 0)+1);
        }
        int n = t.length();
        int all = 0;
        Map<Character, Integer> count = new HashMap<>();
        String ans = "";
        for (int i=0, j=0; j < s.length(); j++) {
            char c = s.charAt(j);
            // 更新 count
            if (total.containsKey(c)) {
                count.put(c, count.getOrDefault(c, 0)+1);
                if (count.get(c) <= total.get(c)) {
                    all++;
                }
            }
            // 找到全部
            if (all == n) {
                // 移动i
                while (i <= j) {
                    if (count.containsKey(s.charAt(i))) {
                        if (count.get(s.charAt(i)) > total.get(s.charAt(i))) {

                            count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
                        }
                        else {
                            break;
                        }
                    }
                    i+=1;
                }
                // 更新 ans
                ans = ans.equals("") || ans.length()>j-i+1 ? s.substring(i, j+1) : ans;
            }
        }
        return ans;
    }
}