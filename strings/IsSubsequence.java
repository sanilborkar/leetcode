/**
 * Problem   : https://leetcode.com/problems/is-subsequence/
 * Submission: https://leetcode.com/submissions/detail/125414963/
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) return true;
        
        int ind = 0;
        boolean match = false;
        for (char c : t.toCharArray()) {
            if (s.charAt(ind) == c) {
                ind++;
                
                if (ind == s.length()) {
                    match = true;
                    break;
                }
            }
        }
        
        return match;
    }
}
