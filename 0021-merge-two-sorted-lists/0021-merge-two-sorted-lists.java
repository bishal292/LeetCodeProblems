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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode head = new ListNode(-1);
        ListNode ans = head;
        while(ptr1 != null && ptr2 != null){
            if(ptr1.val < ptr2.val){
                head.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
            }else if(ptr1.val > ptr2.val){
                head.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next;
            }else{
                head.next = new ListNode(ptr1.val,new ListNode(ptr2.val));
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                head = head.next; // as 2 Nodes are added here so head pointer must move 2 steps ahead so.
            }
            head = head.next; // At least 1 elements are added in each loop so head must move 2 step at each loop iteration.
        }
        if(ptr1 != null){
            head.next = ptr1;
        }
        if(ptr2 != null)head.next = ptr2;
        return ans.next;
    }
}