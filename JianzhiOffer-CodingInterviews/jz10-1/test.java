class Solution {
    private int[] dp = null;
    public Solution(){
        dp = new int[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i=0; i<=100; i++){
            dp[i] = -1;
        }
    }
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int a = fib(n-1);
        if (dp[n-1] == -1)
            dp[n-1] = a;   
        int b = fib(n-2);
        if (dp[n-2] == -1)
            dp[n-2] = b;
        return (a+b)%1000000007;
    }
}
