class Solution {
    // Function to check if placing a queen is safe
    public boolean isSafe(int row, int col, char[][] board, int n) {
        // Check left in the same row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check lower-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Return true if it's safe to place
        return true;
    }

    // Backtracking function to solve N-Queens
    public void solve(int col, char[][] board,
                      List<List<String>> ans, int n) {
        // If all columns are filled, save the solution
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        // Try placing queen in each row for the current column
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                // Place queen
                board[row][col] = 'Q';         
                // Recurse to next column
                solve(col + 1, board, ans, n); 
                // Backtrack
                board[row][col] = '.';         
            }
        }
    }

    // Function to start solving
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start backtracking from column 0
        solve(0, board, ans, n);
        return ans;
    }
}
