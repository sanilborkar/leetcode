/**
 * Problem   : https://leetcode.com/problems/find-the-duplicate-number/
 * Submission: https://leetcode.com/submissions/detail/125256382/
 */

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int n : nums) {
            if (set.contains(n))
                return n;
            
            set.add(n);
        }
        
        return -1;
    }
}
