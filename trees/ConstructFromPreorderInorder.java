/**
 * Problem   : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Submission: https://leetcode.com/submissions/detail/125972373/
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
    static int p;
    
    private int search(int[] arr, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == val) return i;
        }
        
        return -1;
    }
    
    private TreeNode build(int[] preorder, int[] order, int start, int end) {
        //if (order.size() == 0) return null;
        
        if (start > end || p == preorder.length) return null;
        
        int data = preorder[p++];
        TreeNode root = new TreeNode(data);
        
        // If only 1 node is present currently
        if (start == end) return root;
        
        // Find data in inorder
        int i = search(order, start, end, data);
        if (i == -1) return root;
        
        root.left = build(preorder, order, start, i - 1);
        root.right = build(preorder, order, i + 1, end);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //List order = Arrays.asList(inorder);
        
        p = 0;
        return build(preorder, inorder, 0, inorder.length);
    }
}
