// Leetcode 383-ransom-note
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                // add count
                int i = map.get(c) + 1;
                map.remove(c);
                map.put(c, i);
            }
            else {
                map.put(c, 1);
            }
        }

        // scan magazine
        for(Character c : magazine.toCharArray()) {
            if (map.size() == 0) {
                return true;
            }
            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                }
                else {
                    int i = map.get(c) - 1;
                    map.remove(c);
                    map.put(c, i);
                }
            }
            else {
                continue;
            }
        }

        // return
        if (map.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}