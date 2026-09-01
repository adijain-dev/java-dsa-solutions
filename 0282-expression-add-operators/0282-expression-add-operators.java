import java.util.*;

class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        helper(num, target, 0, "", 0, 0);
        return ans;
    }

    private void helper(String s, int target, int i,
                        String path, long eval, long residual) {

        // Base case
        if (i == s.length()) {
            if (eval == target) {
                ans.add(path);
            }
            return;
        }

        String currStr = "";
        long number = 0;

        // Backtracking loop
        for (int j = i; j < s.length(); j++) {

            // Handle leading zero
            if (j > i && s.charAt(i) == '0') {
                return;
            }

            currStr += s.charAt(j);
            number = number * 10 + (s.charAt(j) - '0');

            // First number — no operator before it
            if (i == 0) {

                helper(
                    s,
                    target,
                    j + 1,
                    path + currStr,
                    number,
                    number
                );

            } else {

                // Addition
                helper(
                    s,
                    target,
                    j + 1,
                    path + "+" + currStr,
                    eval + number,
                    number
                );

                // Subtraction
                helper(
                    s,
                    target,
                    j + 1,
                    path + "-" + currStr,
                    eval - number,
                    -number
                );

                // Multiplication
                helper(
                    s,
                    target,
                    j + 1,
                    path + "*" + currStr,
                    eval - residual + residual * number,
                    residual * number
                );
            }
        }
    }
}