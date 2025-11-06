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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode ptr = head;
        while(ptr != null){
            count++;
            ptr = ptr.next;
        }
        ptr = head;
        int i = 0;
        count /= 2;
        while(i < count){
            i++;
            ptr = ptr.next;
        }
        return ptr;
    }
}