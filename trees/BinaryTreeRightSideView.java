/**
 * Problem   : https://leetcode.com/problems/binary-tree-right-side-view/
 * Submission: https://leetcode.com/submissions/detail/125532602/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if (root == null) return ans;
        
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        current.add(root);
        
        TreeNode temp;
        ArrayList<TreeNode> parent;
        while (current.size() > 0) {
            parent = current;
            
            // Get last node
            temp = current.get(0);
            ans.add(temp.val);
                
            current = new ArrayList<TreeNode>();
            // Start filling from the end
            for (TreeNode p : parent) {
                if (p.right != null)
                    current.add(p.right);
                
                if (p.left != null)
                    current.add(p.left);
            }
        }
        
        return ans;
    }
}
