/* Initialize two variables: count to track the count of elements, and element to keep track of the element being counted.
Traverse through the given array. If count is 0, store the current value of the array as element.
If the current element in the array is the same as element, increment the count by 1.
If the current element is different from element, decrement the count by 1.
At the end of the traversal, the integer stored in element will be the expected result (the majority element).

 */

import java.util.*;

// Class containing the majority element logic
class Solution {
    // Function to find the majority element in an array
    public int majorityElement(int[] nums) {
        // Size of the given array
        int n = nums.length;

        // Count variable
        int cnt = 0;

        // Candidate element
        int el = 0;

        // Step 1: Find the potential majority element
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // Step 2: Verify the candidate
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }

        // Return the element if it's a majority
        if (cnt1 > (n / 2)) {
            return el;
        }

        // No majority found
        return -1;
    }
}

// Separate Main class for execution
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        // Create an instance of Solution class
        Solution sol = new Solution();

        // Call the majorityElement function
        int ans = sol.majorityElement(arr);

        // Print the majority element
        System.out.println("The majority element is: " + ans);
    }
}

/* Time Complexity: O(N), where N is the size of the input array. This is because we are iterating through the array once to find the potential majority element and then again to verify it.

Space Complexity: O(1), as we are using only a constant amount of extra space.

 */