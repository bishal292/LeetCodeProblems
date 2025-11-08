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
        if (head == null || head.next == null || k == 1) return head;

        // A dummy node before the actual head helps simplify head operations.
        // It prevents null checks for the first group reversal.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // This pointer will always point to the node *before* the current group to be reversed.
        ListNode prevGroupEnd = dummy;

        while (true) {
            /**
             * Step 1️⃣: Identify the k-th node from prevGroupEnd.
             * Example: For list 1->2->3->4->5 and k=2,
             * - prevGroupEnd = dummy (before 1)
             * - kth = node with value 2
             */
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break; // Not enough nodes for another full group

            // Store the node after the current k-group (start of the next group)
            ListNode nextGroupStart = kth.next;

            /**
             * Step 2️⃣: Reverse the current k-group.
             *
             * Before reversal:
             * prevGroupEnd -> [1 -> 2 -> 3 ...]
             * After reversal (k=2):
             * prevGroupEnd -> [2 -> 1] -> nextGroupStart (3)
             *
             * prev always trails behind curr, and reversal happens by re-linking curr.next.
             */
            ListNode prev = nextGroupStart;    // Acts as the new 'next' link for the last node in group
            ListNode curr = prevGroupEnd.next; // Start node of current group (e.g., 1)

            while (curr != nextGroupStart) {
                // Temporarily save the next node before breaking the link
                ListNode temp = curr.next;

                // Reverse the link: make current node point to 'prev'
                curr.next = prev;

                // Move both pointers one step forward
                prev = curr;
                curr = temp;
            }

            /**
             * Step 3️⃣: Connect the reversed group with the rest of the list
             *
             * prevGroupEnd -> newGroupStart (= kth)
             * newGroupEnd  -> nextGroupStart
             */
            ListNode newGroupStart = kth;          // The kth node is now the new head of the reversed group
            ListNode newGroupEnd = prevGroupEnd.next; // The old group's head is now the tail

            // Connect the previous group with the newly reversed group
            prevGroupEnd.next = newGroupStart;

            // Move prevGroupEnd to the end of this newly reversed group
            prevGroupEnd = newGroupEnd;
        }

        // The dummy node’s next always points to the real (possibly new) head
        return dummy.next;
    }

    /**
     * Utility function to find the k-th node starting from the given node.
     * Returns null if fewer than k nodes remain.
     *
     * Example:
     * getKthNode(dummy, 2) → returns node 2 if dummy.next = node 1
     */
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}