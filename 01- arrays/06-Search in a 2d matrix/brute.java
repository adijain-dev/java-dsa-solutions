/*Input :mat = [ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12] ], target = 8
Output :True.
Explanation :The target = 8 exists in the 'mat' at index (1, 3).

Input :mat = [ [1, 2, 4], [6, 7, 8], [9, 10, 34] ], target = 78
Output :false.
Explanation :The target = 78 does not exist in the 'mat'. Therefore in the output, we see 'false'.

 */

/* The extremely naive approach is to get the answer by checking all the elements of the given matrix. So, we will traverse the matrix and check every element if it is equal to the given ‘target’.
We will use a loop(say i) to select a particular row at a time.
Next, for every row, we will use another loop(say j) to traverse each column.
Inside the loops, we will check if the element i.e. matrix[i][j] is equal to the ‘target’. If we find any matching element, we will return true.
Otherwise, after completing the traversal, we will return false.

 */

import java.util.*;

public class Solution {
    // Function to search for a target value in the matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get number of rows in the matrix
        int n = matrix.length;

        // Get number of columns in the matrix
        int m = matrix[0].length;

        // Traverse each row
        for (int i = 0; i < n; i++) {
            // Traverse each column in the current row
            for (int j = 0; j < m; j++) {
                // Check if the current element matches the target
                if (matrix[i][j] == target)
                    return true;
            }
        }

        // Return false if the target is not found
        return false;
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        // Define a 2D matrix
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        // Create an object of the Solution class
        Solution obj = new Solution();

        // Call the searchMatrix function and print the result
        if (obj.searchMatrix(matrix, 8))
            System.out.println("true");
        else
            System.out.println("false");
    }
}

/* Time Complexity: O(n × m), We are traversing the entire matrix with `n` rows and `m` columns. In the worst case, we may end up visiting every cell once if the target is not present. So, the total number of operations is proportional to the number of elements in the matrix.

Space Complexity: O(1),We are not using any additional space. The algorithm uses a constant amount of extra memory regardless of the size of the matrix just loop variables and the target. Therefore, the space complexity is constant.

 */

