/**
 * Problem   : https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * Submission: https://leetcode.com/submissions/detail/125337320/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        ArrayList<TreeNode> parent = new ArrayList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        
        current.add(root);
        
        while(current.size() > 0) {
            parent = current;
            current = new ArrayList<TreeNode>();
            
            for(TreeNode n : parent) {
                if (n != null) {
                    current.add(n.left);
                    current.add(n.right);
                    max = Math.max(max, n.val);
                }
            }
            
            if (current.size() > 0) {
                result.add(max);
                max = Integer.MIN_VALUE;                
            }
        }
        
        return result;
    }
}
