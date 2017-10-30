/**
 * Problem   : https://leetcode.com/problems/contains-duplicate/
 * Submission: https://leetcode.com/submissions/detail/125993222/
 */


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int n : nums) {
            if (set.contains(n))
                return true;
            
            set.add(n);
        }
        
        return false;
    }
}
