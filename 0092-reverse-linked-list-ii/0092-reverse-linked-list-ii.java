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
        if (left == right) return head; /// if only one Node is asked to reverse.
        ListNode newHead = new ListNode(0, head);
        ListNode before = newHead;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode prev = null;
        ListNode curr = before.next;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        before.next.next = curr;
        before.next = prev;
        return newHead.next;
    }
}