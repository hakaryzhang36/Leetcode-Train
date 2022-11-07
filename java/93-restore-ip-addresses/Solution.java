// Leetcode 93-restore-ip-addresses
class Solution {
    List<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> ip = new LinkedList<>();
        reverse(s, ip);
        return res;
    }

    private void reverse(String s, LinkedList<String> ip) {
        // System.out.println(s);
        if (s.length() == 0) {
            return;
        }
        // last fragment
        if (ip.size() == 3) {
            if (s.length() > 1 && s.charAt(0) == '0') {
                return;
            }
            if (s.length() <= 3 && Integer.parseInt(s) <= 255) {
                ip.add(s);
                // combine each ip fragment into a address
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    if (i == 0) {
                        sb.append(ip.get(0));
                    }
                    else {
                        sb.append("." + ip.get(i));
                    }
                }
                res.add(sb.toString());
                ip.removeLast();
            }
            return;
        }
        // split s to get a fragment, then go reverse
        for (int i = 0; i <= 2 && i < s.length(); i++) {
            if (s.charAt(0) == '0') {   // s start with 0, fragment will only be "0"
                ip.add("0");
                reverse(s.substring(1, s.length()), ip);
                ip.removeLast();
                return;
            }
            else {
                // validity check
                String fragment = s.substring(0, i+1);
                if (Integer.parseInt(fragment) <= 255) {
                    ip.add(fragment);
                    reverse(s.substring(i+1, s.length()), ip);
                    ip.removeLast();
                }
                else {
                    return;
                }
            }
        }
    }
}