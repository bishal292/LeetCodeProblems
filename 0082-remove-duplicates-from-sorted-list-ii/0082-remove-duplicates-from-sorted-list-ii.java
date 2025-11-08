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
        // if(head == null || head.next == null)return head;

        // ListNode newHead = new ListNode(0);
        // ListNode ptr = newHead;
        // ListNode prev = null;
        // ListNode cur = head;
        // ListNode next = head.next;

        // while(cur != null){
        //     if(next != null && cur.val == next.val){
        //         prev = cur;
        //         cur = next;
        //         next = next.next;
        //     }else{
        //         if(prev == null || cur.val != prev.val){
        //             ptr.next = cur;
        //             ptr = ptr.next;
        //             prev = cur;
        //             cur = next;
        //             prev.next = null;
        //             if(next != null)
        //             next = next.next;
        //         }else{
        //             prev = cur;
        //             cur = next;
        //             if(next != null)
        //             next = next.next;
        //         }
        //     }
        // }
        // return newHead.next;



        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);  // Dummy head before the actual list
        ListNode prev = dummy;                   // Tracks the last node before duplicates

        while (head != null) {
            // Skip nodes with the same value
            boolean isDuplicate = false;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                isDuplicate = true;
            }

            if (isDuplicate) {
                // Skip all duplicates
                prev.next = head.next;
            } else {
                // Move prev pointer forward if no duplicate found
                prev = prev.next;
            }

            head = head.next; // Move forward
        }

        return dummy.next;
    }
}