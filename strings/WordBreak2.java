/**
 * Problem   : https://leetcode.com/problems/word-break-ii/
 * Submission: https://leetcode.com/submissions/detail/125796687/
 */

class Solution {
    HashSet<String> map = new HashSet<String>();
    HashMap<Integer, ArrayList<String>> solution = new HashMap<Integer, ArrayList<String>>();
    
    private ArrayList<String> getValid(String s, int start) {
        if (solution.containsKey(start))
            return solution.get(start);
        
        ArrayList<String> ans = new ArrayList<String>();
        
        if (start == s.length()) {
            ans.add("");
            solution.put(start, ans);
            return ans;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String first = s.substring(start, end);
            String second = s.substring(end);
            
            if (map.contains(first)) {                
                ArrayList<String> list = getValid(s, end);                
                for (String str : list) {
                    String space = str.equals("") ? "" : " ";
                    String result = String.format("%s%s%s", first, space, str);
                    
                    ans.add(result);
                }
            }
        }
        
        solution.put(start, ans);
        return ans;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return null;
        
        for (String str : wordDict) {
            map.add(str);
        }
        
        return getValid(s, 0);
    }
}
