/* Example 1:
Input Format:arr[] = [1,0,-1,0,-2,2], target = 0
Result: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Explanation:We have to find unique quadruplets from the array such that the sum of those elements is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

Example 2:
Input Format: arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
Result: [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
Explanation: The sum of all the quadruplets is equal to the target i.e. 9.

 */

/* Create a set to keep only unique groups of four numbers.
Use the first loop from the start of the array to the end to choose the first number.
Inside it, run a second loop starting from the next position to choose the second number.
Then, run a third loop starting from the next position after the second number to choose the third number.
Finally, run a fourth loop starting from the next position after the third number to choose the fourth number.
Check if the total of these four numbers equals the target value.
If yes, arrange the four numbers in order and add them to the set.
Once all loops are done, return the set as a list of unique groups of four numbers.

 */

import java.util.*;

class Solution {
    // Function to find quadruplets with sum = target
    public List<List<Integer>> fourSum(int[] arr, int target) {
        // Get size of array
        int n = arr.length;
        // Use set to avoid duplicate quadruplets
        Set<List<Integer>> set = new HashSet<>();

        // First loop - pick first element
        for (int i = 0; i < n; i++) {
            // Second loop - pick second element
            for (int j = i + 1; j < n; j++) {
                // Third loop - pick third element
                for (int k = j + 1; k < n; k++) {
                    // Fourth loop - pick fourth element
                    for (int l = k + 1; l < n; l++) {
                        // Calculate sum of four numbers
                        long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                        // If sum matches target
                        if (sum == target) {
                            // Create quadruplet
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            // Sort to maintain uniqueness
                            Collections.sort(temp);
                            // Add to set
                            set.add(temp);
                        }
                    }
                }
            }
        }
        // Convert set to list and return
        return new ArrayList<>(set);
    }
}

public class Main {
    public static void main(String[] args) {
        // Input array
        int[] arr = {1, 0, -1, 0, -2, 2};
        // Target sum
        int target = 0;

        // Create object
        Solution obj = new Solution();
        // Get result
        List<List<Integer>> ans = obj.fourSum(arr, target);

        // Print result
        for (List<Integer> quad : ans) {
            System.out.println(quad);
        }
    }
}

/* Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.
Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.

 */