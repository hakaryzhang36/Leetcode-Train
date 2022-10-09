// Leetcode 49-group-anagrams
// mark
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<int[]> charMapsList = new ArrayList<int[]>();
        List<List<String>> classifiedList = new ArrayList<List<String>>();
        for (String str : strs) {
            // create a new charMap
            int[] charMap = new int[26];
            for (char c : str.toCharArray()) {
                charMap[(int)c - (int)'a'] += 1;
            }

            // compare new charMap to each charMap
            boolean isMatch = false;
            for(int i = 0; !isMatch && i < charMapsList.size(); i++) {
                int[] existedCharMap = charMapsList.get(i);
                
                for (int k = 0; k < 26; k++) {
                    if (existedCharMap[k] != charMap[k]) {
                        isMatch = false;
                        break;
                    }
                    else {
                        isMatch = true;
                    }
                }

                if(isMatch) {
                classifiedList.get(i).add(str);

                    break;
                }
            }

            // if no match, add a new charMap
            if (!isMatch) {
                charMapsList.add(charMap);
                List<String> l = new ArrayList<String>();
                l.add(str);
                classifiedList.add(l);
            }
        }

        return classifiedList;
    }
}