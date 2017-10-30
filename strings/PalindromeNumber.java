/**
 * Problem   : https://leetcode.com/problems/palindrome-number/
 * Submission: https://leetcode.com/submissions/detail/125184941/
 */

class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }
}
