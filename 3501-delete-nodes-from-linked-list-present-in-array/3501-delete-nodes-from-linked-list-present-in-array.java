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
    public ListNode modifiedList(int[] nums, ListNode head) {

        // HashMap<Integer, Integer> track = new HashMap<>();
        // ListNode ptr = head;
        // while (ptr != null) {
        //     track.put(ptr.val, track.getOrDefault(ptr.val, 0) + 1);
        //     ptr = ptr.next;
        // }
        // for (int num : nums) {
        //     int count = track.getOrDefault(num, 0);// get the count of elements in the linkedlist.
        //     int i = 0;
        //     ptr = head; // again point to head
        //     while (i < count) { // remove All Occurances from the 
        //         if (ptr.val == num && ptr == head) {// If the it is the head from the linkedList 
        //             head = head.next;
        //             ptr = head;
        //             i++;
        //         } else if (ptr.next.val == num) { // just behind the target num which is to be removed from the list.
        //             ptr.next = ptr.next.next;
        //             i++;
        //         } else {
        //             ptr = ptr.next;
        //         }
        //     }
        // }



        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        while(head != null && set.contains(head.val)){ //remove all concecutive elems to be removed from the starting(Head).
            head = head.next;
        }
        if(head == null)return null;

        ListNode ptr = head;
        while(ptr.next != null){
            if(set.contains(ptr.next.val)){
                ptr.next = ptr.next.next;
            }else{
                ptr = ptr.next;
            }
        }
        return head;
    }
}