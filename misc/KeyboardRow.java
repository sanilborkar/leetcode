/**
 * Problem   : https://leetcode.com/problems/keyboard-row/
 * Submission: https://leetcode.com/submissions/detail/125294085/
 */

class Solution {
    private HashMap<Character, Integer> createMap() {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('a', 2); map.put('b', 3); map.put('c', 3); map.put('d', 2);
        map.put('e', 1); map.put('f', 2); map.put('g', 2); map.put('h', 2);
        map.put('i', 1); map.put('j', 2); map.put('k', 2); map.put('l', 2);
        map.put('m', 3); map.put('n', 3); map.put('o', 1); map.put('p', 1);
        map.put('q', 1); map.put('r', 1); map.put('s', 2); map.put('t', 1);
        map.put('u', 1); map.put('v', 3); map.put('w', 1); map.put('x', 3);
        map.put('y', 1); map.put('z', 3);
        
        return map;
    }
    
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> map = createMap();
        ArrayList<String> ans = new ArrayList<String>();
        
        for (String w : words) {
            char[] arr = w.toLowerCase().toCharArray();
            
            if (!map.containsKey(arr[0]))
                continue;
            
            int row = map.get(arr[0]);
            boolean flag = true;
            
            for (char c : arr) {
                if (!map.containsKey(c) || map.get(c) != row) {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
                ans.add(w);
        }
        
        return ans.toArray(new String[0]);
    }
}
