/**
 * Problem   : https://leetcode.com/problems/reverse-linked-list/
 * Submission: https://leetcode.com/submissions/detail/125767236/
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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode next = head.next;
        head.next = null;
        
        ListNode ahead = null;
        
        while(next != null) {
            ahead = next.next;
            
            next.next = head;
            head = next;
            next = ahead;
        }
        
        return head;
    }
}
