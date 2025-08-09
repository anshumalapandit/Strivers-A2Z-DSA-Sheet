class Solution {
    public void helper(int row, int col, int m, int n, boolean chang[], int vis[][], int grid[][]) {
        // base case
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return; // invalid place , operator is imp if any one of the conditon hit it should return back
        }
        if (vis[row][col] == 1) {
            return; // if its visited then come bcak
        }
        if (grid[row][col] == 1) {
            vis[row][col] = 1;
            // make it rotten
            grid[row][col] = 2;
            chang[0] = true; // rotten done
        }
    }

    public int orangesRotting(int[][] grid) {
        // top,right,bottom,left
        int rowDir[] = { -1, 0, 1, 0 };
        int colDir[] = { 0, 1, 0, -1 };
        int m = grid.length; // it is rows 
        int n = grid[0].length; // it is cols
        int min = 0; // minimum minutes taken to destory its surrouned fresh apple
        while (true) {
            boolean changed[] = new boolean[1]; // assuming no rotten apple
            int vis[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2 && vis[i][j] == 0) {
                        // if it is rotten then 
                        // first mark it visited 
                        vis[i][j] = 1;
                        // by default=false;
                        // lets travel all 4 direction
                        for (int d = 0; d < 4; d++) {
                            // we know 4 fixed directions
                            int newRow = i + rowDir[d];
                            int newCol = j + colDir[d];
                            helper(newRow, newCol, m, n, changed, vis, grid);
                        }
                    }
                }
            }
            // check is this able to rotten anyone
            if (!changed[0]) {
                // yes done rottem
                break;
            }
            min++;
        }
        // check if any fresh orange left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min;
    }
}
