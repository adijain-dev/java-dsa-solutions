
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long MOD = 1_000_000_007L;

        int[] left = previousSmaller(arr);
        int[] right = nextSmaller(arr);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long leftCount = i - left[i];
            long rightCount = right[i] - i;

            sum = (sum + (long) arr[i] * leftCount
                        % MOD * rightCount) % MOD;
        }

        return (int) sum;
    }

    // Previous strictly smaller element's index
    private int[] previousSmaller(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                top--;
            }

            left[i] = (top >= 0) ? stack[top] : -1;
            stack[++top] = i;
        }

        return left;
    }

    // Next smaller or equal element's index
    private int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && arr[stack[top]] > arr[i]) {
                top--;
            }

            right[i] = (top >= 0) ? stack[top] : n;
            stack[++top] = i;
        }

        return right;
    }
}