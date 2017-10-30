/**
 * Problem   : https://leetcode.com/problems/find-leaves-of-binary-tree/
 * Submission: https://leetcode.com/submissions/detail/125919149/
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
    private int getLeaves(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return 0;
        }
        
        int left = getLeaves(node.left, res);
        int right = getLeaves(node.right, res);
        int level = Math.max(left, right);
        
        if (level >= res.size())
            res.add(new ArrayList<Integer>());
        
        res.get(level).add(node.val);
        
        return level + 1;
    } 
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();    
        getLeaves(root, res);
        return res;
    }
}
