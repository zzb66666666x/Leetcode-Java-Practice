class Solution {
    private boolean[][] vis;
    private int m;
    private int n;

    public int maxAreaOfIsland(int[][] g) {
        m = g.length;
        n = g[0].length;
        vis = new boolean[m][n];
        int maxarea = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (g[i][j] == 1){
                    int area = dfs(g, i, j);
                    maxarea = area>maxarea? area : maxarea;
                }
            }
        }
        return maxarea;
    }

    private int dfs(int[][] g, int i, int j){
        if (i<0 || j<0 || i>=m || j>=n){
            return 0;
        }
        if (g[i][j] == 1){
            if (vis[i][j] == true)
                return 0;
            vis[i][j] = true;
            int a = dfs(g, i-1, j);
            int b = dfs(g, i+1, j);
            int c = dfs(g, i, j-1);
            int d = dfs(g, i, j+1);
            return 1+a+b+c+d;
        }else{
            return 0;
        }
    }
}
