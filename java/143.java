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
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        if (head.next.next == null) {
            head.next.next = head;
            head.next.next = null;
            return;
        }
        List<ListNode> NodeList = new ArrayList<ListNode>();
        ListNode curr = head;
        while (curr != null) {
            NodeList.add(curr);
            curr = curr.next;
        }
        int length = NodeList.size();
        boolean fromFront = true;
        curr = head;
        curr.next = NodeList.get(length - 1);
        curr = curr.next;
        for (int i = 1; i <= length / 2 - 1;) {
            if (fromFront == true) {
                curr.next = NodeList.get(i);
            } else {
                curr.next = NodeList.get(length - 1 - i);
                i++;
            }
            curr = curr.next;
            fromFront = !fromFront;
        }
        if (length % 2 == 1) {
            curr.next = NodeList.get(length / 2);
            curr = curr.next;
        }
        curr.next = null;
    }
}