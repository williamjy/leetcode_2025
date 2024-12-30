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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean addTen = false;
        ListNode head = new ListNode();
        ListNode curr = head;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            if (addTen == true) {
                sum += 1;
            }
            int digit = sum % 10;
            ListNode next = new ListNode(digit);
            curr.next = next;
            curr = curr.next;
            if (sum >= 10) {
                addTen = true;
            } else {
                addTen = false;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (addTen == true) {
            ListNode next = new ListNode(1);
            curr.next = next;
        }
        return head.next;
    }
}