/**
 * Problem   : https://leetcode.com/problems/reverse-linked-list/
 * Submission: https://leetcode.com/submissions/detail/125767236/
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
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
    private ListNode addNumbers(ListNode l1, ListNode l2, int carry) {
        // Only carry remaining
        if (l1 == null && l2 == null) {
            if (carry != 0) return new ListNode(carry);
            else return null;
        }
        
        int sum = carry;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;
        
        ListNode sumNode = new ListNode(sum % 10);
        sumNode.next = addNumbers(l1 == null ? null : l1.next,
                                  l2 == null ? null : l2.next,
                                  sum/10);
        
        return sumNode;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumbers(l1, l2, 0);
    }
}
