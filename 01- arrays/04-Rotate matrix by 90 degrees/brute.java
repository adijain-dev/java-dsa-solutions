/* In a 90-degree clockwise rotation, each element in the matrix moves from its original position to a new position based on a specific pattern. The first column becomes the first row (in reverse order) and second column becomes the second row, and so on.
We can simulate this movement by using a new matrix. For each element at position (i, j) in the original matrix, we calculate its new position in the rotated matrix as (j, n - i - 1) where n is the size of the matrix.
Initialize an empty matrix of the same size (n x n).
Loop through every element of the original matrix using two nested loops.
For each element at position (i, j), place it in the new matrix at position (j, n - i - 1).
After completing the placement for all elements, return or copy the new matrix.

 */

import.java.util.*;
class Solution {
    // Function to rotate the matrix 90 degrees clockwise using extra space
    public int[][] rotateClockwise(int[][] matrix) {
        // Get the size of the square matrix
        int n = matrix.length;

        // Create a new matrix of same size to store rotated result
        int[][] rotated = new int[n][n];

        // Traverse each element of original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Place the element at its new rotated position
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }

        // Return the rotated matrix
        return rotated;
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Solution obj = new Solution();
        int[][] rotated = obj.rotateClockwise(mat);

        // Print the rotated matrix
        for (int[] row : rotated) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}

/* Time Complexity: O(N²),Each element of the matrix is visited exactly once and placed into a new matrix, so the time taken is proportional to the total number of elements.

Space Complexity: O(N²),We use an additional matrix of the same size to store the rotated result, leading to O(N²) extra space.

 */