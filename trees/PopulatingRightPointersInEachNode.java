/**
 * Problem   : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Submission: https://leetcode.com/submissions/detail/125498064/
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        ArrayList<TreeLinkNode> current = new ArrayList<TreeLinkNode>();
        current.add(root);
        
        ArrayList<TreeLinkNode> parent;
        while (current.size() > 0) {
            parent = current;
            current = new ArrayList<TreeLinkNode>();
            int size = parent.size();
            
            for (TreeLinkNode p : parent) {
                if (p != null) {                    
                    int i = parent.indexOf(p);
                    if (i + 1 < size)
                        p.next = parent.get(i+1);
                    // else
                    //     p.next = null;
                    
                    current.add(p.left);
                    current.add(p.right);
                }
            }
        }
    }
}
