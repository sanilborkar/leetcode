/**
 * Problem   : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Submission: https://leetcode.com/submissions/detail/125899240/
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        HashMap<Character, Integer> seen = new HashMap<Character, Integer>();
        
        int max = 0, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (!seen.containsKey(c))
                seen.put(c, i);
            else {
                i = seen.get(c);
                seen.clear();
            }
            
            max = Math.max(max, seen.size());
        }
        
        return max;
    }
}
