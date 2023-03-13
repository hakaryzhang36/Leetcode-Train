// Leetcode 438-find-all-anagrams-in-a-string
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 初始化哈希map
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> leftMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
            leftMap.put(p.charAt(i), leftMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        // i，j分别为子串前后指针
        // 如果 j-i+1==pLength，则表示找到子串
        // 如果 尾字符在map中有剩余，即未匹配，则纳入子串
        // 如果 尾字符在map中无剩余，即超出匹配
        //      i向前移动到map[尾字符]有剩余/i==j为止
        // 如果 尾字符不在map中，i=j+1，重置map
        for (int i = -1, j = 0; j < s.length(); j++) {
            Character end = s.charAt(j);
            // case 1: 有剩余
            if (leftMap.getOrDefault(end, 0) > 0) {
                leftMap.put(end, leftMap.get(end)-1);
                // 判断子串长度是否达标
                if (j - (i+1) + 1 == p.length()) {
                    ans.add(i+1);
                    leftMap.put(s.charAt(i+1), leftMap.get(s.charAt(i+1))+1);
                    i+=1;
                }
            }
            // case 2: end 根本不在 map 内
            else if (leftMap.get(end) == null) {
                for (Map.Entry<Character, Integer> e : map.entrySet()) {
                    leftMap.put(e.getKey(), e.getValue());
                }
                i = j;
            }
            // case 3: 移动左指针，更新 leftmap，腾出位置给 end
            else {
                // 前移 i
                while (i <= s.length() && i < j) {
                    leftMap.put(s.charAt(i+1), leftMap.get(s.charAt(i+1))+1);
                    i++;
                    // 尝试end是否有剩余，如果end根本不在p内，则必然不可能剩余
                    if (leftMap.getOrDefault(end, 0) > 0) {
                        leftMap.put(end, leftMap.get(end)-1);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}