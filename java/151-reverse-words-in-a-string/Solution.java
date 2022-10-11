// Leetcode 151-reverse-words-in-a-string
class Solution {
    public String reverseWords(String s) {
        /*
            Because String is unchangable in Java.
            We try to work on a char[] and solve in-place with O(1) extra space.
        */
        char[] cstr = s.toCharArray();
        int length = 0;

        // remove leading and trailing spaces
        for(int i = 0, j = 0; j < cstr.length;) {
            // move to word
            while (j < cstr.length && cstr[j] == ' ') {
                j++;
            }
            // move the word
            while (j < cstr.length) {
                if (cstr[j] == ' ' && cstr[j - 1] == ' ') {
                    break;
                }
                cstr[i++] = cstr[j++];
                length++;
            }
        }
        
        if (cstr[length - 1] == ' ') {
            length -= 1;
        }
        
        int i = 0, j = length - 1;
        // reverse s
        while (i < j) {
            char c = cstr[i];
            cstr[i] = cstr[j];
            cstr[j] = c;
            i++;
            j--;
        }


        // reverse each word
        i = 0;
        while (i < length) {
            int p = i;
            while (p < length && cstr[p] != ' ') {
                p++;
            }
            int k = i;
            i = p + 1;
            p -= 1;
            while (k < p) {
                char c = cstr[k];
                cstr[k] = cstr[p];
                cstr[p] = c;
                k++;
                p--;
            }   

        }
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < length; k++) {
            sb.append(cstr[k]);
        }
        return sb.toString();
    }
}