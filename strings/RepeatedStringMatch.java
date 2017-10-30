/**
 * Problem   : https://leetcode.com/problems/repeated-string-match/
 * Submission: https://leetcode.com/submissions/detail/122239740/
 */

class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A.isEmpty()) {
            return -1;
        }
        
        if (A.contains(B)) {
            return 1;
        }
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.toString().length() <= B.length()) {
            count++;
            sb.append(A);
            if (sb.toString().contains(B)) {
                return count;
            }
        }
        
        if (sb.append(A).toString().contains(B)) {
            return count + 1;
        }
        
        return -1;
    }
}
