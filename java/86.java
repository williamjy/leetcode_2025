/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-300);
        ListNode left = leftHead;
        ListNode rightHead = new ListNode(-300);
        ListNode right = rightHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                left.next = curr;
                left = left.next;
                curr = curr.next;
                left.next = null;
            } else {
                right.next = curr;
                right = right.next;
                curr = curr.next;
                right.next = null;
            }
        }
        if (leftHead.next != null) {
            left.next = rightHead.next;
            return leftHead.next;
        } else {
            return rightHead.next;
        }
    }
}