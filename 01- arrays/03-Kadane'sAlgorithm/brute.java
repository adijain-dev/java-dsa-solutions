/* Iterate through the array with variable i, which represents the starting index of each subarray. The possible values for i range from 0 to n-1, where n is the size of the array.
Inside the first loop, run another loop with variable j that represents the ending index of the subarray. For each i, j can range from i to n-1.
For each subarray defined by i and j, iterate through its elements to calculate the sum. Maintain a variable, max, to store the maximum sum encountered so far during the iteration.
At each step, compare the current subarray sum with the current max value. If the current sum is greater, update the max value with the new sum.
Finally, after completing all iterations, return the max variable, which holds the maximum sum of any subarray.
*/

import java.util.*;

class Solution {
    // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {

        /* Initialize maximum sum with
           the smallest possible integer */
        int maxi = Integer.MIN_VALUE;

        // Iterate over each starting index of subarrays
        for (int i = 0; i < nums.length; i++) {

            /* Iterate over each ending index
               of subarrays starting from i */
            for (int j = i; j < nums.length; j++) {

                /* Variable to store the sum
                   of the current subarray */
                int sum = 0;

                // Calculate the sum of subarray nums[i...j]
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                /* Update maxi with the maximum of its current
                   value and the sum of the current subarray */
                maxi = Math.max(maxi, sum);
            }
        }

        // Return the maximum subarray sum found
        return maxi;
    }
}

// Separate Main class
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

/* Time Complexity: O(N^3), where N is the size of the array. This is because we have three nested loops: one for the starting index, one for the ending index, and one for calculating the sum of the subarray.

Space Complexity: O(1), as we are using a constant amount of space for variables, regardless of the input size.
*/