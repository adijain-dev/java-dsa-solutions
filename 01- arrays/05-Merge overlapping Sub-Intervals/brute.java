/* Input : intervals=[[1,3],[2,6],[8,10],[15,18]]
Output : [[1,6],[8,10],[15,18]]
Explanation : Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6] intervals.
Input : [[1,4],[4,5]]
Output :  [[1,5]]
Explanation :  Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].

 */

/* The main idea is to combine intervals that overlap with each other. To do this easily, we first sort the intervals by their starting point so that all overlapping intervals come next to each other. Then, for each interval, we try to see if the next ones overlap with it. If they do, we merge them into one bigger interval. We keep doing this until we find a non-overlapping interval, and then start the process again from that point.
Sort all intervals based on their starting points. This helps bring all overlapping intervals next to each other.
Go through each interval one by one and if the current interval is already covered by a previously merged interval, skip it. Else, pick the current interval as the starting point of a new merged interval.
Now run another loop to check if the following intervals overlap with the current one
If the start of next interval is less than or equal to the end of the current merged interval, it means they overlap. Therefore, extend the end of the merged interval to be the maximum of the two ends.
Keep doing this for the next intervals as long as they overlap. As soon as you find an interval that doesn't overlap, break the inner loop and move back to the outer loop to process the next non-overlapping interval.
Store each merged interval in the final answer list and after the loop ends, return the list of merged intervals.

 */

import java.util.*;

class Solution {
    // Function to merge overlapping intervals using brute force
    public List<List<Integer>> merge(int[][] intervals) {

        // Sort intervals based on starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        // Loop through intervals
        while (i < n) {
            // Start of merged interval
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            // Check all overlapping intervals
            while (j < n && intervals[j][0] <= end) {
                // Extend the end of current interval
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            // Add merged interval to result
            ans.add(Arrays.asList(start, end));

            // Move to next non-overlapping interval
            i = j;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<List<Integer>> result = sol.merge(intervals);
        for (List<Integer> interval : result) {
            System.out.print(interval + " ");
        }
    }
}

/* Time Complexity: O(N^2), for every interval we check all future intervals.
Space Complexity: ON), additonal space used to store the non-overlapping intervals.

 */