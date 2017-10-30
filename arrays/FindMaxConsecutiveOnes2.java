/**
 * Problem   : https://leetcode.com/problems/max-consecutive-ones-ii/
 * Submission: https://leetcode.com/submissions/detail/125303968/
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 1;
        
        int curr = 0;
        int prev = 0;
        boolean allOnes = true;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) curr++;
            else {
                allOnes = false;

                // Check next int
                if (i + 1 < nums.length) {
                    prev = nums[i + 1] == 1 ? curr : 0;
                    curr = 0;
                }
            }
            
            max = Math.max(max, prev + 1 + curr);
        }

        if (allOnes)
            return nums.length;
        
        return max;
    }
}
