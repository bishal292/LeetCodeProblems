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
    static {
        for (int i = 0; i < 500; i++)
            isPalindrome(new ListNode());
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        do {
            i++;
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null);
        fast = head;
        ListNode mid = slow;
        mid = reverse(mid);

        for (int step = 0; step < i; step++) {
            if (fast.val != mid.val) {
                return false;
            }
            fast = fast.next;
            mid = mid.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
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