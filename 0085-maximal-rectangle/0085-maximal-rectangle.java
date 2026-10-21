
import java.util.Stack;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Update histogram heights for the current row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Find the largest rectangle in this histogram
            maxArea = Math.max(
                maxArea,
                largestRectangleInHistogram(heights)
            );
        }

        return maxArea;
    }

    private int largestRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty()
                    && heights[stack.peek()] > currentHeight) {

                int height = heights[stack.pop()];

                int leftBoundary = stack.isEmpty()
                        ? -1
                        : stack.peek();

                int width = i - leftBoundary - 1;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return maxArea;
    }
}
