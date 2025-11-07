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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // if (left == right) return head; /// if only one Node is asked to reverse.
        // ListNode newHead = new ListNode(0, head);
        // ListNode before = newHead;

        // for (int i = 1; i < left; i++) {
        //     before = before.next;
        // }

        // ListNode prev = null;
        // ListNode curr = before.next;
        // for (int i = left; i <= right; i++) {
        //     ListNode next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }

        // before.next.next = curr;
        // before.next = prev;
        // return newHead.next;



        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }
}