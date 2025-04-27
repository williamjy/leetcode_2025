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
    public ListNode reverseKGroup(ListNode head, int k) {
        int counter = 0;
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        head = new ListNode(0, head);
        ListNode k_head = head.next;
        ListNode k_tail = head;
        ListNode prev = head;
        curr = head.next;
        // List<ListNode> k_list = new ArrayList<ListNode> ();
        // while (curr != null) {
        //     if (counter == 0) {
        //         k_list.add(curr);
        //     }
        //     counter = (counter + 1) % k;
        //     curr = curr.next;
        // }
        int list_count = length / k + 1;
        while (curr != null && list_count > 0) {
            if (counter == 0) {
                k_head = curr;
                k_tail = prev;
                prev = curr;
                curr = curr.next;
                list_count--;
            } else {
                prev.next = curr.next;
                curr.next = k_head;
                k_head = curr;
                curr = prev.next;
                k_tail.next = k_head;
            }
            counter = (counter + 1) % k;
        }
        return head.next;
    }
}