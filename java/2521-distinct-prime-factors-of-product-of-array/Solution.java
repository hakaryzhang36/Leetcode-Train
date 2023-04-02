// Leetcode 2521-distinct-prime-factors-of-product-of-array
class Solution {
    Set<Integer> ansSet = new HashSet<>();
    public int distinctPrimeFactors(int[] nums) {
        for (int num : nums) {
            getPrimeFactors(num);
        }
        return ansSet.size();
    }

    // 质因数分解
    public void getPrimeFactors(int num) {
        for (int i = 2; i*i <= num; i++) {
            if (num%i == 0) {
                if (!ansSet.contains(i)) {
                    ansSet.add(i);
                }
                while (num%i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            if (!ansSet.contains(num)) {
                ansSet.add(num);
            }
        }
    }
}