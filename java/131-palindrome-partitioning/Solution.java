// Leetcode 131-palindrome-partitioning
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        LinkedList<String> list = new LinkedList<>();
        recurse(s, list);
        return res;
    }

    public void recurse(String s, LinkedList<String> list){
        // if substring[0, p] is palindrome, recurse split substring[p + 1, n]
        for (int p = 0; p < s.length(); p++) {
            if (isPalindrome(s.substring(0, p + 1))) {
                list.add(s.substring(0, p + 1));
                if (p == s.length() - 1) {
                    res.add(new ArrayList(list));
                    list.removeLast();
                    return;
                }
                recurse(s.substring(p + 1, s.length()), list);
                list.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}