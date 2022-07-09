class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        int rows = matrix.length;
        if (rows == 0)
            return false;
        int cols = matrix[0].length;
        if (cols == 0)
            return false;
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0 ){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
