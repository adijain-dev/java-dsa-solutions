
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : heights[i];

            while (top >= 0 && heights[stack[top]] > curr) {
                int h = heights[stack[top--]];
                int width = (top == -1) ? i : i - stack[top] - 1;
                int area = h * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return maxArea;
    }
}
