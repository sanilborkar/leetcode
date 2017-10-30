/**
 * Problem   : https://leetcode.com/problems/sort-transformed-array/
 * Submission: https://leetcode.com/submissions/detail/125922450/
 */

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0)
            return new int[1];
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int n : nums) {
            int val = a*(int)Math.pow(n, 2);
            val += b*n;
            val += c;
            heap.add(val);
        }
        
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[i] = heap.poll();
        
        return res;
    }
}
