/* Input : head -> 1 -> 2 -> 3 -> 4 -> 5, k = 2
Output : head -> 4 -> 5 -> 1 -> 2 -> 3
Explanation :List after 1 shift to right: head -> 5 -> 1 -> 2 -> 3 -> 4.
List after 2 shift to right: head -> 4 -> 5 -> 1 -> 2 -> 3.

 */

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    // Function to rotate the list to the right by k positions
    public ListNode rotateRight(ListNode head, int k) {
        // If list is empty or has one node or no rotation needed
        if (head == null || head.next == null || k == 0) return head;

        // Repeat rotation k times
        for (int i = 0; i < k; i++) {
            // Initialize pointers for traversal
            ListNode curr = head;
            ListNode prev = null;

            // Traverse to the last node
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            // Cut the last node
            prev.next = null;

            // Move it to the front
            curr.next = head;
            head = curr;
        }

        // Return rotated list
        return head;
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        // Create linked list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();
        int k = 2;
        ListNode result = sol.rotateRight(head, k);

        // Print result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

/* Time Complexity: O(k * n),We are performing `k` rotations. In each rotation. We traverse the list to reach the second-last node (this takes O(n) time), then we adjust a few pointers (which is O(1)). So the overall time complexity is O(k * n). This approach becomes inefficient if k is large, especially with long lists, because each rotation traverses the full list.

Space Complexity: O(1), We do not use any additional data structures.

 */