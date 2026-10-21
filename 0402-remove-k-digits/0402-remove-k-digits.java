
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !st.isEmpty()
                    && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        String res = "";

        while (!st.isEmpty()) {
            res = st.peek() + res;
            st.pop();
        }

        // Remove leading zeros
        while (res.length() > 0 && res.charAt(0) == '0') {
            res = res.substring(1);
        }

        return res.isEmpty() ? "0" : res;
    }
}
