/* Imagine laying intervals out on a number line. If two intervals overlap, we can combine them into one, like merging blocks that touch or overlap.

Instead of checking each interval with every other one (as in brute-force), we first sort the intervals, so that any overlapping intervals will come one after the other. This way, we only need to compare each interval with the last one added to our answer. If they overlap, we merge them. If they don’t, we simply add the current interval as a new entry.
Sort the intervals based on their starting points. This ensures overlapping intervals come together.
Initialize an empty list to store the final merged intervals.
If the list is empty or the current interval starts after the last one ends, it means there is no overlap, so just add it to the list.
If the current interval starts before or exactly at the end of the last one, it means there is overlap. So, combine both by extending the end of the last one to the further end of the two.
Keep doing this until all intervals have been checked. The final list will now contain only non-overlapping, merged intervals.

 */

import java.util.*;

class Solution {
    // Function to merge overlapping intervals
    public List<List<Integer>> merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(
                intervals,
                (a, b) -> Integer.compare(a[0], b[0])
        );

        // List to store merged intervals
        List<List<Integer>> merged = new ArrayList<>();

        // Traverse through all intervals
        for (int[] interval : intervals) {
            // If merged list is empty or no overlap
            if (
                    merged.isEmpty() ||
                            merged.get(merged.size() - 1).get(1) < interval[0]
            ) {
                // Add current interval as a new block
                merged.add(
                        Arrays.asList(interval[0], interval[1])
                );
            } else {
                // Overlapping: update end to max of both
                int last = merged.size() - 1;
                int maxEnd = Math.max(
                        merged.get(last).get(1),
                        interval[1]
                );
                merged.get(last).set(1, maxEnd);
            }
        }

        return merged;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        List<List<Integer>> result = sol.merge(intervals);

        for (List<Integer> interval : result) {
            System.out.print(
                    "[" + interval.get(0) + "," + interval.get(1) + "] "
            );
        }
    }
}

/*Time Complexity: O(N*logN) + O(N), we sort the entire array and then merge them in a single pass.
Space Complexity: ON), additonal space used to store the non-overlapping intervals.

 */