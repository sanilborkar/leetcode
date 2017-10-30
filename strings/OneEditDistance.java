/**
 * Problem   : https://leetcode.com/problems/one-edit-distance/
 * Submission: https://leetcode.com/submissions/detail/125835065/
 */

class Solution {
    private boolean isOneReplace(String s, String t) {
        int i = 0;
        boolean diff = false;
        
        while (i < s.length()) {
            if (s.charAt(i) != t.charAt(i)) {
                if (diff) return false;

                diff = true;    
            }            
            i++;
        }
        
        return true;
    }
    
    private boolean isOneInsert(String s, String t) {
        int i = 0, j = 0;
        boolean diff = false;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (diff) return false;
                
                diff = true;
                
                if (s.length() > t.length())
                    i++;
                else
                    j++;
                
            } else {
                i++;
                j++;    
            }
        }
        
        return true;
    }
    
    public boolean isOneEditDistance(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        
        if (s.equals(t))
            return false;
        
        if (s_len == t_len)
            return isOneReplace(s, t);
        
        if (s_len == t_len + 1)
            return isOneInsert(s, t);
        
        if (s_len + 1 == t_len)
            return isOneInsert(s, t);
        
        return false;
    }
}
