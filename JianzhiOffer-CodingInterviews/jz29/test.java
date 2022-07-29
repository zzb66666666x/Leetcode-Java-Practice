class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null)
            return new int[0];
        int m = matrix.length;
        if (m==0)
            return new int[0];
        int n = matrix[0].length;
        if ( n==0)
            return new int[0];
        int cnt = 0;
        int i=0; int j=0;
        int left = 0;
        int up = 0;
        int down = m-1;
        int right = n-1;
        int dir = 0;
        int[] ret = new int[m*n];
        while (cnt < m*n){
            if (dir == 0){
                if (j>right){
                    up++;
                    dir = (dir+1)%4;
                    j--;
                    i++;
                    continue;
                }
                ret[cnt++] = matrix[i][j];
                j++;
            }else if (dir == 1){
                if (i > down){
                    i--;
                    right--;
                    dir = (dir+1)%4;
                    j--;
                    continue;
                }
                ret[cnt++] = matrix[i][j];
                i++;
            }else if (dir == 2){
                if (j < left){
                    down--;
                    j++;
                    i--;
                    dir = (dir+1)%4;
                    continue;
                }
                ret[cnt++] = matrix[i][j];
                j--;
            }else{//dir=3
                if (i < up){
                    left++;
                    i++;
                    j++;
                    dir = (dir+1)%4;
                    continue;
                }
                ret[cnt++] = matrix[i][j];
                i--;
            }
        }
        return ret;
    }
}
