
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            // Remove larger digits to get the smallest number
            while (k > 0 && !stack.isEmpty()
                    && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // If removals are still left, remove digits from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the result string
        StringBuilder result = new StringBuilder();

        for (char digit : stack) {
            result.append(digit);
        }

        // Remove leading zeros
        int index = 0;
        while (index < result.length()
                && result.charAt(index) == '0') {
            index++;
        }

        String answer = result.substring(index);

        // Return "0" if the result is empty
        return answer.isEmpty() ? "0" : answer;
    }
}
