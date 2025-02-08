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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }
        ListNode beforeLeft = null;
        ListNode afterRight = null;
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 1; i <= right; i++) {
            if (i == left) {
                if (prev == null) {
                    beforeLeft = new ListNode(-1000, curr);
                } else {
                    beforeLeft = prev;
                }
            } else if (i == right) {
                afterRight = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        prev = beforeLeft.next;
        curr = beforeLeft.next.next;
        for (int i = left; i < right; i++) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        beforeLeft.next.next = afterRight;
        beforeLeft.next = prev;
        if (left == 1) {
            return beforeLeft.next;
        } else {
            return head;
        }
    }
}