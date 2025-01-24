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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode curr = head;
        int length = 0;
        for (ListNode node = head; node != null;) {
            node = node.next;
            length++;
        }
        n = length - n + 1;
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                if (curr == head) {
                    head = head.next;
                } else if (curr.next == null) {
                    prev.next = null;
                } else {
                    prev.next = curr.next;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}