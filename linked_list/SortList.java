/**
 * Problem   : https://leetcode.com/problems/sort-list/description/
 * Submission: https://leetcode.com/submissions/detail/126694190/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
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
    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;
        
        if (first.val <= second.val) {
            first.next = merge(first.next, second);
            return first;
        }
            
        second.next = merge(second.next, first);
        return second;
    }
    
    private ListNode sort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode prev = head, slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        // Now, we have 2 lists: (head --> prev) and (slow --> fast)
        ListNode first = sort(head);
        ListNode second = sort(slow);
        
        return merge(first, second);
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        
        return sort(head);
    }
}