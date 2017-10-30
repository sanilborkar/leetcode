/**
 * Problem   : https://leetcode.com/problems/single-number/
 * Submission: https://leetcode.com/submissions/detail/125256204/
 */

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> set = new HashMap<Integer, Boolean>();
        
        for(int n : nums) {
            if (set.containsKey(n))
                set.remove(n);
            else
                set.put(n, true);
        }
        
        if (set.size() != 1) return -1;
        
        for (int n : set.keySet())
            return n;
        
        return -1;
    }
}
