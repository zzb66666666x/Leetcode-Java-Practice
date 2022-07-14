class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null)
            return 0;
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        if (n == 0)
            return 0;
        int[][] dp = new int [m+1][n+1];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]) + grid[i][j];
            }
        }
        return dp[m][n];
    }
}
