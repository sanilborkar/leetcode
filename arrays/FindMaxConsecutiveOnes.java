/**
 * Problem   : https://leetcode.com/problems/max-consecutive-ones/
 * Submission: https://leetcode.com/submissions/detail/125302122/
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        
        int count = 0;
        for (int n : nums) {
            if (n == 1) count++;
            else {
                if (max < count) max = count;
                count = 0;
            }
        }
        
        // There are all 1s in the end
        return Math.max(max, count);
    }
}
