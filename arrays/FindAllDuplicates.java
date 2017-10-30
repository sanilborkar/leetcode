/**
 * Problem   : https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Submission: https://leetcode.com/submissions/detail/125971247/
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        
        /*  Since all numbers > 0, for all a = nums[i],
            set nums[a] = -nums[a]
            Then all the elements that are < 0 were duplicates.
            To find the missing numbers = index for num[index] > 0.
        */
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;      // 0 indexed
            
            if (nums[index] < 0) {
                int missing = index + 1;
                ans.add(missing);
            }
            else
                nums[index] = (-1)*nums[index];
        }
        
        return ans;
    }
}
