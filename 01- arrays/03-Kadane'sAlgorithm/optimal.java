/* Iterate through the array using a variable i. During each iteration, add the current element arr[i] to a running sum variable.
Keep track of the maximum sum encountered during the iteration by comparing the current sum with the previous maximum sum, and update it if the current sum is greater.
If at any point the sum becomes negative, reset it to 0, as a negative sum won't contribute positively to the overall maximum sum.
Continue the iteration until all elements in the array are processed.
Finally, return the maximum sum encountered during the iteration.
 */

import java.util.*;

class Solution {
    // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {

        // Maximum sum
        long maxi = Long.MIN_VALUE;

        // Current sum of subarray
        long sum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Add current element to the sum
            sum += nums[i];

            // Update maxi if current sum is greater
            if (sum > maxi) {
                maxi = sum;
            }

            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the maximum subarray sum found
        return (int) maxi;
    }
}

// Separate Main class in same file
public class Main {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Create an instance of Solution class
        Solution sol = new Solution();

        int maxSum = sol.maxSubArray(arr);

        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}

/* Time Complexity: O(n), where n is the number of elements in the array. We traverse the array only once.

Space Complexity: O(1). We use a constant amount of space for variables.

 */