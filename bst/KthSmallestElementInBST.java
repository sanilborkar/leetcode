/**
 * Problem   : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Submission: https://leetcode.com/submissions/detail/125524127/
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
    private int size(TreeNode root) {
        if (root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        
        int leftSize = size(root.left);
        if (k == leftSize + 1)
            return root.val;
        else if (k < leftSize + 1)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k - (leftSize + 1));
    }
}
