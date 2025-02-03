class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        
        for (int i = 0; i < row; i++) {
            dfs(board, visited, i, 0, false);
            dfs(board, visited, i, column - 1, false);
        }

        for (int j = 0; j < column; j++) {
            dfs(board, visited, 0, j, false);
            dfs(board, visited, row - 1, j, false);
        }

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < column - 1; j++) {
                dfs(board, visited, i, j, true);
            }
        }
    }

    public void dfs (char[][] board, boolean[][] visited, int i, int j, boolean isSurrounded) {
        int row = board.length;
        int column = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= column) {
            return;
        }
        if (board[i][j] == 'X') {
            visited[i][j] = true;
        }
        if (!visited[i][j]) {
            visited[i][j] = true;
            dfs(board, visited, i - 1, j, isSurrounded);
            dfs(board, visited, i + 1, j, isSurrounded);
            dfs(board, visited, i, j - 1, isSurrounded);
            dfs(board, visited, i, j + 1, isSurrounded);
            if (isSurrounded) {
                board[i][j] = 'X';
            }
        }
    }
}