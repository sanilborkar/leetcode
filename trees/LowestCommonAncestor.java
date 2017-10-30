/**
 * Problem   : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Submission: https://leetcode.com/submissions/detail/125495143/
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
    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
    
    private TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return root;
        
        if (root == p) return p;
        else if (root == q) return q;
        
        boolean pOnLeft = covers(root.left, p);
        boolean qOnLeft = covers(root.left, q);
        if (pOnLeft != qOnLeft) return root;
        
        TreeNode childSide = pOnLeft ? root.left : root.right;
        return getLCA(childSide, p, q);
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) return null;
        
        return getLCA(root, p , q);
    }
}
