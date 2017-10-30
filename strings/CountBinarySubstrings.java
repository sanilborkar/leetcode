/**
 * Problem   : https://leetcode.com/problems/count-binary-substrings/
 * Submission: https://leetcode.com/submissions/detail/125213874/
 */

class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prev = 0, cur = 1;
        
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i))
                cur++;
            else {
                count += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        
        return count + Math.min(prev, cur);
    }
}
