/* The optimal approach uses two pointers to efficiently calculate the trapped water without extra space for arrays. The key insight is that the amount of water trapped at any position depends on the tallest bars to the left and right of that position. By maintaining two pointers starting from both ends of the elevation array and tracking the maximum heights encountered so far from both sides, we can determine the trapped water at each step. If the left height is smaller or equal to the right height, the trapped water depends on the left side's maximum; otherwise, it depends on the right side's maximum. This two-pointer technique lets us compute trapped water in one pass while using constant extra space.

 */

class Solution {
    // Function to calculate trapped rainwater using the optimal two-pointer approach
    public int trap(int[] height) {
        int n = height.length;

        // Initialize two pointers at both ends of the array
        int left = 0;
        int right = n - 1;

        // Variables to track the maximum height to the left and right
        int maxLeft = 0;
        int maxRight = 0;

        // Variable to store total trapped water
        int totalWater = 0;

        // Iterate until left pointer meets right pointer
        while (left <= right) {
            // If left bar is smaller or equal to right bar
            if (height[left] <= height[right]) {
                // If current left bar is higher than maxLeft, update maxLeft
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    // Water trapped on left is difference between maxLeft and current height
                    totalWater += maxLeft - height[left];
                }
                left++; // Move left pointer to the right
            } else {
                // If current right bar is higher than maxRight, update maxRight
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    // Water trapped on right is difference between maxRight and current height
                    totalWater += maxRight - height[right];
                }
                right--; // Move right pointer to the left
            }
        }

        // Return total trapped water
        return totalWater;
    }
}

/* Time Complexity: O(n) because the two pointers traverse the array only once, each pointer moving inward and covering the entire array in total linear time.

Space Complexity: O(1) as only constant extra space is used for pointers and variables, regardless of input size.

 */