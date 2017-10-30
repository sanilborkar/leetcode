/**
 * Problem   : https://leetcode.com/problems/degree-of-an-array/
 * Submission: https://leetcode.com/submissions/detail/125226360/
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> degreeMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> startIndex = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> endIndex = new HashMap<Integer, Integer>();
        
        for (int n : nums) {
            if (degreeMap.containsKey(n)) {
                degreeMap.put(n, degreeMap.get(n) + 1);
            } else {
                degreeMap.put(n, 1);
            }
        }
        
        int deg = 1;
        for (int n : degreeMap.values()) {
            deg = Math.max(deg, n);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!startIndex.containsKey(nums[i])) {
                startIndex.put(nums[i], i);
            }
            
            endIndex.put(nums[i], i);
        }
        
        int len = nums.length;
        for (int n : nums) {
            if (degreeMap.get(n) == deg) {
                len = Math.min(len, endIndex.get(n) - startIndex.get(n) + 1);
            }
        }
        
        return len;
    }
}
