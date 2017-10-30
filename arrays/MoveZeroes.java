/**
 * Problem   : https://leetcode.com/problems/move-zeroes/
 * Submission: https://leetcode.com/submissions/detail/125830707/
 */

class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        PriorityQueue<Integer> zeros = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeros.add(i);
        }
        
        if (zeros.size() == 0) return;
        
        int z = zeros.poll();
        for (int i = z + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, z, i);                
                zeros.add(i);
                z = zeros.poll();
            }
        }
    }
}
