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
        if (head == null || head.next == null)
            return;/// if Only 1 Node is there.
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != null && fast.next != null);

        slow = reverse(slow);// reverse the list after the middle element;
        fast = head;
        ListNode ptr = head;
        
        while (fast != null && slow != null) {
            fast = fast.next;
            ptr.next = slow;
            ptr = ptr.next;
            slow = slow.next;
            ptr.next = fast;
            ptr = ptr.next;
        }
        if(fast != null)fast.next = null;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;/// if Only 1 Node is there.

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }
        head = prev;
        return head;
    }
}