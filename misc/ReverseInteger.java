/**
 * Problem   : https://leetcode.com/problems/reverse-integer/
 * Submission: https://leetcode.com/submissions/detail/125931305/
 */

class Solution {
    private int countDigits(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        
        return count;
    }
    
    public int reverse(int x) {
        int n = (x >= 0) ? x : Math.abs(x);
        long ans = 0L;
        
        // Count number of digits
        int power = countDigits(n) - 1;
        
        while (n > 0) {
            int digit = n % 10;
            long sum = digit*(long)Math.pow(10, power);
            
            if ((ans + sum) > Integer.MAX_VALUE)
                return 0;
            
            ans += sum;
            
            n /= 10;
            power--;
        }
        
        return (x > 0) ? (int)ans : (int)ans*(-1);
    }
}
