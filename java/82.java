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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-200, head);
        ListNode prev = newHead;
        ListNode curr = head;
        while (curr != null) {
            int counter = 1;
            while (curr.next != null && curr.val == curr.next.val) {
                counter++;
                curr = curr.next;
            }
            if (counter > 1) {
                curr = curr.next;
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return newHead.next;
    }
}