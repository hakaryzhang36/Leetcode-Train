// Leetcode 05.02-bianry-number-to-string-lcci
class Solution {
    public String printBin(double num) {

        Double bd = num;
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        for (int i = 0; i < 32 && bd.compareTo(0.0) != 0; i++) {
            bd = bd * 2;
            if (bd.compareTo(1.0) > 0 || bd.compareTo(1.0) == 0) {
                sb.append("1");
                bd = bd - 1.0;
            }
            else if (bd.compareTo(1.0) < 0){
                sb.append("0");
            }
        }

        if (bd.compareTo(0.0) == 0) {
            return sb.toString();
        }
        else {
            return "ERROR";
        }
    }
}