class Solution {

    // Directions: down, up, right, left
    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private boolean find(char[][] board, int i, int j, int idx, String word) {

        // Base case: entire word has been found
        if (idx == word.length()) {
            return true;
        }

        // Check boundaries and whether this cell is already visited
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            board[i][j] == '$') {
            return false;
        }

        // Current cell does not match current character of word
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Store the original character
        char temp = board[i][j];

        // Mark this cell as visited
        board[i][j] = '$';

        // Explore all four directions
        for (int[] dir : directions) {

            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (find(board, newI, newJ, idx + 1, word)) {
                return true;
            }
        }

        // Backtrack: restore the original character
        board[i][j] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        // Try starting the word from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0) &&
                    find(board, i, j, 0, word)) {

                    return true;
                }
            }
        }

        return false;
    }
}