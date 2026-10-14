
import java.util.Stack;

class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

    // Sum of all subarray maximums
    private long sumSubarrayMax(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() &&
                   (i == n || nums[st.peek()] < nums[i])) {

                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                sum += (long) nums[mid] * leftCount * rightCount;
            }

            if (i < n) {
                st.push(i);
            }
        }

        return sum;
    }

    // Sum of all subarray minimums
    private long sumSubarrayMin(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() &&
                   (i == n || nums[st.peek()] > nums[i])) {

                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                sum += (long) nums[mid] * leftCount * rightCount;
            }

            if (i < n) {
                st.push(i);
            }
        }

        return sum;
    }
}