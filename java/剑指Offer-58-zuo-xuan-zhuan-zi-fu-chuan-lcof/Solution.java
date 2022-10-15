// Leetcode 剑指Offer-58-zuo-xuan-zhuan-zi-fu-chuan-lcof
class Solution {
    public String reverseLeftWords(String s, int n) {
        // reverse front string
        String front = reverse(s.substring(0, n));
        // reverse rear string
        String rear = reverse(s.substring(n, s.length()));
        // reverse string
        return reverse(front + rear);
    }

    public String reverse(String s) {
        int i = 0, j = s.length() - 1;
        char[] cstr = s.toCharArray();
        while(i < j) {
            char c =  cstr[i];
            cstr[i] = cstr[j];
            cstr[j] = c;
            i++;
            j--;
        }
        return new String(cstr); 
    }
}