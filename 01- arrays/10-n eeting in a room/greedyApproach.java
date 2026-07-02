/* Input: N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
Output: [1, 2, 4, 5]
Explanation: These meeting can be conducted in the room.
 */

import java.util.*;

// Class representing a Meeting
class Meeting {
    int start;
    int end;

    // Constructor
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {

    public int maxMeetings(int start[], int end[]) {

        int n = start.length;

        // Store all meetings in a list
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        // Sort meetings according to their ending time
        Collections.sort(meetings, (a, b) -> Integer.compare(a.end, b.end));

        // Select the first meeting
        int count = 1;
        int lastEndTime = meetings.get(0).end;

        // Traverse remaining meetings
        for (int i = 1; i < n; i++) {

            // If the current meeting starts after the previous meeting ends,
            // select it.
            if (meetings.get(i).start > lastEndTime) {
                count++;
                lastEndTime = meetings.get(i).end;
            }
        }

        return count;
    }
}

public class Main {

    public static void main(String[] args) {

        // Input arrays
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        // Create object of Solution class
        Solution obj = new Solution();

        // Call the function
        int ans = obj.maxMeetings(start, end);

        // Print the result
        System.out.println("Maximum meetings that can be accommodated = " + ans);
    }
}

/* Time Complexity: O(N*logN) + O(N), We sort the entire start and end time array and then iterate over every interval one by one.
Space Complexity: O(N), additional space used to store tuple of start time, end time and index.
 */