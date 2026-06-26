/*Example 1:
Input:
 nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
Output:
 7
Explanation:
 The number 7 appears 5 times in the 9-sized array, making it the most frequent element.

 */

/* Iterate through the array to select each element one by one.
For each selected element, run another loop to count its occurrences in the given array.
If the occurrence of any element is greater than the floor of (N/2), return that element immediately as the majority element.

 */

import java.util.*;

// Class containing the majority element logic
class Solution {
    // Function to find the majority element in an array
    public int majorityElement(int[] nums) {

        // Size of the given array
        int n = nums.length;

        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {

            // Counter to count occurrences of nums[i]
            int cnt = 0;

            // Count the frequency of nums[i] in the array
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }

            // Check if frequency of nums[i] is greater than n/2
            if (cnt > (n / 2)) {
                // Return the majority element
                return nums[i];
            }
        }

        // Return -1 if no majority element is found
        return -1;
    }
}

// Separate class containing only the main method
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        // Create an instance of Solution class
        Solution sol = new Solution();

        int ans = sol.majorityElement(arr);

        // Print the majority element found
        System.out.println("The majority element is: " + ans);
    }
}

/* Time Complexity: O(N^2), where N is the size of the input array. This is because we are using a nested loop to count the occurrences of each element.

Space Complexity: O(1), as we are using a constant amount of space for the counters and indices.

 */