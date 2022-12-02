// Leetcodee 394-decode-string
class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        for (int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);
            if (ch == ']') {
                // get substr
                int times = nums.pop();
                StringBuilder sb_t = new StringBuilder();
                Stack<String> temp = new Stack<>();
                while(!strs.peek().equals("[")) {
                    temp.push(strs.pop());
                }
                strs.pop();
                while (!temp.empty()) {
                    sb_t.append(temp.pop());
                }
                String substr = sb_t.toString();
                StringBuilder sb_c = new StringBuilder();
                // repeat substr
                for (int i = 0; i < times; i++) {
                    sb_c.append(substr);
                }
                strs.push(sb_c.toString());
            }
            else if (ch > '0' && ch <= '9') {
                int num = ch - '0';
                while (s.charAt(k + 1) >= '0' && s.charAt(k + 1) <= '9') {
                    num = num * 10 + (s.charAt(k + 1) - '0');
                    k++;
                }
                nums.push(num);
            }
            else {
                strs.push(String.valueOf(ch));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        while (!strs.empty()) {
            list.add(strs.pop());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}