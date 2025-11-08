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
        if(head == null || head.next == null)return head;

        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        while(cur != null){
            if(next != null && cur.val == next.val){
                prev = cur;
                cur = next;
                next = next.next;
            }else{
                if(prev == null || cur.val != prev.val){
                    ptr.next = cur;
                    ptr = ptr.next;
                    prev = cur;
                    cur = next;
                    prev.next = null;
                    if(next != null)
                    next = next.next;
                }else{
                    prev = cur;
                    cur = next;
                    if(next != null)
                    next = next.next;
                }
            }
        }
        return newHead.next;
    }
}