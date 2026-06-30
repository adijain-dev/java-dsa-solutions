/* When we rotate a linked list to the right by k positions,
each node is effectively shifted forward k steps.
Instead of performing k individual rotations,
we observe that rotating a list by its own length results in the same list.
 So, we only need to rotate by k % length.
 We first compute the length of the list and connect the last node to the head,
  forming a circular linked list. Then we locate the new tail,
  which is at length - (k % length) steps from the start.
  The node next to this becomes the new head, and we break the circular link there.
  This transforms the list in a single traversal, making the process efficient.

 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    // Function to rotate the linked list to the right by k places
    public ListNode rotateRight(ListNode head, int k) {
        // If list is empty or only one node or k = 0, return head
        if (head == null || head.next == null || k == 0)
            return head;

        // Initialize length and tail
        int length = 1;
        ListNode tail = head;

        // Traverse to find tail and calculate length
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make the list circular
        tail.next = head;

        // Calculate effective rotation
        k = k % length;

        // Traverse to new tail position
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // New head is next of newTail
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}

// Driver code
public class Main {
    public static void main(String[] args) {
        // Creating linked list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        Solution obj = new Solution();
        ListNode newHead = obj.rotateRight(head, k);

        // Print rotated list
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        System.out.println();
    }
}

/* Time Complexity: O(N), We perform a single traversal to calculate the length, another to find the new tail, and one for final breaking all linear operations.

Space Complexity: O(1),No extra space is used; we just adjust pointers in place.

 */