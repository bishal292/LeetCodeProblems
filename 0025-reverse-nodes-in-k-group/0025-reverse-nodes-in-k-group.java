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
// class Solution {
//     public static ListNode reverseKGroup(ListNode head, int k) {
//         if (head == null || head.next == null || k == 1)
//             return head;
//         int count = 1;
//         ListNode ptr = head; /// Pointer node to track node at each step
//         ListNode curHead = head; /// pointer to track the head of the running current group of k Nodes.
//         ListNode prev = null; /// Pointer to keep track of the previous last Node from the group,so that new
//                               /// reversed head can be connected with.
//         head = null;
//         while (ptr != null) {
//             if (count % k == 1) { /// if new group of k is being started
//                 curHead = ptr;
//             }
//             if (count % k == 0) { /// if successfully formed the group of k Node
//                 ListNode next = ptr.next; /// keeps track of the next node just after the last node at the kth pos.
//                 ptr.next = null; /// break the connection from the last (kth) node.
//                 ListNode newHead = reverse(curHead); /// returns the new head after the reversal of the portion
//                 if (prev != null) /// if this was not the first portion which is being reversed then connect the
//                                   /// last Node from previous reversed group with the newHead.
//                     prev.next = newHead;
//                 if (head == null) /// If this was the first group which is being traversed then the newHead will
//                                   /// also be the head of the ans after final traversal.
//                     head = newHead;

//                 /// As we know after reversal the head of the group becomes the tail of the
//                 /// reversed list so again establish the connection with next which was
//                 /// broken earlier.
//                 curHead.next = next;
//                 prev = curHead; /// Now the tail of the current kth group will act as the previous Node for next
//                                 /// k reversed Nodes As we know that after reversal the head and tail are swapped
//                                 /// so we also need to move the pointer to the tail after reversal.
//                 ptr = curHead;
//             }
//             ptr = ptr.next;
//             count++;
//         }

//         return head;
//     }

//     public ListNode reverse(ListNode head) {
//         if (head == null || head.next == null)
//             return head;
//         ListNode prev = null;
//         ListNode curr = head;
//         ListNode next = head.next;
//         while (curr != null) {
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//             if (next != null)
//                 next = next.next;
//         }
//         return prev;
//     }
// }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        // Dummy node simplifies head handling
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Step 1: Check if k nodes exist ahead
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null)
                break;

            ListNode nextGroupStart = kth.next;

            // Step 2: Reverse current k-group
            ListNode prev = nextGroupStart;
            ListNode curr = prevGroupEnd.next;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Step 3: Connect reversed group back
            ListNode newGroupStart = prev;
            ListNode newGroupEnd = prevGroupEnd.next;
            prevGroupEnd.next = newGroupStart;
            prevGroupEnd = newGroupEnd;
        }

        return dummy.next;
    }

    // Helper to get kth node from current node
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
