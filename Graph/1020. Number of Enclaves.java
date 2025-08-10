class Solution {
    public int helper(int row, int col, int m, int n, int[][] vis, boolean[] change, int[][] grid) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            change[0] = true; // touched boundary
            return 0;
        }
        // if its visited or its water then return aa jao
        if (vis[row][col] == 1 || grid[row][col] == 0) return 0;

        vis[row][col] = 1; // mark visited
        int count = 1; // count this cell

        // explore 4 directions
        // top
        count += helper(row - 1, col, m, n, vis, change, grid);
        // bottom
        count += helper(row + 1, col, m, n, vis, change, grid);
        // left
        count += helper(row, col - 1, m, n, vis, change, grid);
        // right
        count += helper(row, col + 1, m, n, vis, change, grid);

        return count;
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int move = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    boolean[] change = new boolean[1];
                    int cells = helper(i, j, m, n, vis, change, grid);
                    if (!change[0]) move += cells; // only add if it's enclosed
                }
            }
        }
        return move;
    }
}
