// 质因数分解
class Solution {
    public void getPrimeFactors(int num) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i*i <= num; i++) {
            if (num%i == 0) {
                primeFactors.add(i);
                while (num%i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            if (!ansSet.contains(num)) {
                primeFactors.add(i);
            }
        }
    }
}