/**
 * Problem   : https://leetcode.com/problems/subtree-of-another-tree/
 * Submission: https://leetcode.com/submissions/detail/125412873/
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
    private boolean matchTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        if (s.val == t.val)
            return matchTree(s.left, t.left) && matchTree(s.right, t.right);
        
        return false;
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        
        if (s.val == t.val && matchTree(s, t))
            return true;
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
