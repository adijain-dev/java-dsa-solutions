/* Input : height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output : 6
Explanation : Water is trapped in the dips between bars. The total trapped water units add up to 6 (1+1+2+1+1).

 */

import java.util.*;

class Solution {
    // Function to calculate trapped rainwater using brute force approach
    public int trap(int[] height) {
        int n = height.length;

        // Variable to store total trapped water
        int totalWater = 0;

        // Iterate over each bar in the elevation map
        for (int i = 0; i < n; i++) {
            // Initialize max heights to the left and right of current bar
            int maxLeft = 0;
            int maxRight = 0;

            // Find maximum height to the left of current bar
            for (int j = 0; j <= i; j++) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }

            // Find maximum height to the right of current bar
            for (int j = i; j < n; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            // Water trapped on current bar is min of maxLeft and maxRight minus current height
            totalWater += Math.min(maxLeft, maxRight) - height[i];
        }

        // Return total trapped water
        return totalWater;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input elevation map
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        // Create Solution object
        Solution sol = new Solution();

        // Calculate trapped water
        int result = sol.trap(height);

        // Print the result
        System.out.println("Trapped Rainwater: " + result);
    }
}

/* Time Complexity: O(n²) because for each bar, we scan all bars to its left and right to find the maximum height, resulting in nested loops.

Space Complexity: O(1) as no additional data structures are used proportional to input size, only variables to track max heights and total water.

 */