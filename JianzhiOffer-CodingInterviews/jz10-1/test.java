// method1: dp
// class Solution {
//     private int[] dp = null;
//     public Solution(){
//         dp = new int[101];
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 1;
//         for (int i=0; i<=100; i++){
//             dp[i] = -1;
//         }
//     }
//     public int fib(int n) {
//         if (n == 0)
//             return 0;
//         if (n == 1)
//             return 1;
//         if (dp[n] != -1)
//             return dp[n];
//         int a = fib(n-1);
//         if (dp[n-1] == -1)
//             dp[n-1] = a;   
//         int b = fib(n-2);
//         if (dp[n-2] == -1)
//             dp[n-2] = b;
//         return (a+b)%1000000007;
//     }
// }

// method2: fast matrix multiply
class Solution{
    public int fib(int n){
        if (n == 0)
            return 0;
        if (n==1)
            return 1;
        n--;
        int[][] mat = new int[][]{{1,1},{1,0}};
        int[][] ret = new int[][]{{1,0},{0,1}};
        while (n > 0){
            if ((n&1)!=0){
                ret = mult(mat, ret);
            }
            n = n>>1;
            mat = mult(mat, mat);
        }
        return ret[0][0];
    }

    private int[][] mult(int[][] a, int[][] b){
        int[][] ret = new int[2][2];
        ret[0][0] = (int)(((long)a[0][0]*(long)b[0][0] + (long)a[0][1]*(long)b[1][0]) % 1000000007);
        ret[0][1] = (int)(((long)a[0][0]*(long)b[0][1] + (long)a[0][1]*(long)b[1][1]) % 1000000007);
        ret[1][0] = (int)(((long)a[1][0]*(long)b[0][0] + (long)a[1][1]*(long)b[1][0]) % 1000000007);
        ret[1][1] = (int)(((long)a[1][0]*(long)b[0][1] + (long)a[1][1]*(long)b[1][1]) % 1000000007);
        return ret;
    }
}
