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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0)return head;
        int size = 0;
        ListNode cur = head;
        ListNode lastNode = null;
        while(cur != null){
            size++;
            lastNode = cur;
            cur = cur.next;
        }
        k = k % size;
        if(k == 0)return head;
        
        size -= k+1;
        cur = head;
        while(size >0){// move the pointer to the node just before the node after which the rotaion is to be held.
            size--;
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        lastNode.next = head;
        head = next;

        return head;
    }
}