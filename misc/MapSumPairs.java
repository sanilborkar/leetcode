/**
 * Problem   : https://leetcode.com/problems/map-sum-pairs/
 * Submission: https://leetcode.com/submissions/detail/123815704/
 */

import java.util.regex.*;

class MapSum {

    HashMap<String, Integer> map;
    
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        String pattern = String.format("^(%s)", prefix);
        Pattern r = Pattern.compile(pattern);
        
        int sum = 0;
        for (String key : map.keySet()) {
            Matcher m = r.matcher(key);
            if (m.find()) {
                sum += map.get(key);   
            }
        }
        
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
