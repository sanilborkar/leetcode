/**
 * Problem   : https://leetcode.com/problems/reverse-words-in-a-string/
 * Submission: https://leetcode.com/submissions/detail/125569049/
 */

public class Solution {
    public String reverseWords(String s) {
        if (s == null) return s;
        if (s.trim().isEmpty()) return s.trim();
        
        s = s.trim();
        
        // Only 1 word
        if (!s.contains(" ")) return s;
        
        String[] tokens = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (tokens[i] != null && !tokens[i].isEmpty()) {
                sb.append(tokens[i]);
                sb.append(" ");    
            }
        }
        
        return sb.toString().trim();
    }
}
