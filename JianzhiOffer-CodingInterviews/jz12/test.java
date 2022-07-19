class Solution {
    public boolean exist(char[][] board, String word) {
        // System.out.println(board.length);
        // System.out.println(board[0].length);
        if (word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (dfs(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int progress, int r, int c){
        // System.out.println("r="+r+" c="+c+" prog="+progress);
        if (progress == word.length())
            return true;
        int m = board.length;
        int n = board[0].length;
        if (r >= m || c >= n || r<0 || c < 0)
            return false;
        if (board[r][c] == word.charAt(progress)){
            progress++;
            char val = board[r][c];
            board[r][c] = ' ';
            boolean ret = dfs(board, word, progress, r+1, c) || dfs(board, word, progress, r, c+1) || 
                          dfs(board, word, progress, r-1, c) || dfs(board, word, progress, r, c-1);
            if (!ret){
                board[r][c] = val;
            }
            return ret;
        }else{
            return false;
        }
    }   
}
