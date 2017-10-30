/**
 * Problem   : https://leetcode.com/problems/binary-search-tree-iterator/
 * Submission: https://leetcode.com/submissions/detail/125493712/
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    ArrayList<TreeNode> nodes;
    int size;
    int ind;
    
    private void getInorder(TreeNode root) {
        if (root != null) {
            getInorder(root.left);
            nodes.add(root);
            getInorder(root.right);
        }
    }
    
    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<TreeNode>();
        getInorder(root);
        size = nodes.size();
        ind = 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return size > 0 && ind < size;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = nodes.get(ind);
        ind++;
        return n.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
