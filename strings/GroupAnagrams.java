/**
 * Problem   : https://leetcode.com/problems/group-anagrams/
 * Submission: https://leetcode.com/submissions/detail/125250386/
 */

class Solution {
    private String sorted(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (String s : strs) {
            String str = sorted(s);
            ArrayList<String> list;
                
            if (map.containsKey(str))
                list = map.get(str);
            else
                list = new ArrayList<String>();
            
            list.add(s);
            map.put(str, list);
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        for (ArrayList<String> al : map.values())
            ans.add(al);
        
        return ans;
    }
}
