/**
 * Problem   : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Submission: https://leetcode.com/submissions/detail/125249005/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) return null;
        
        ListNode p = head;
        for(int i = 0; i < n; i++) {
            if (p == null) return null;
            p = p.next;
        }
        
        ListNode start = head;
        ListNode prev = null;
        while (p != null) {
            p = p.next;
            prev = start;
            start = start.next;
        }
        
        if (start.next != null) {
            start.val = start.next.val;
            start.next = start.next.next;
        } else {
            start = null;
            
            if (p == null && prev == null)
                return null;
            else
                prev.next = null;
        }

        return head;
    }
    
//     private void delete(ListNode N) {
//         if (N == null) return;
        
//         if (N.next != null) {
//             N.val = N.next.val;
//             N.next = N.next.next;
//         } else {
//             // N.next = null;
//             N = null;
//         }
//     }
}
