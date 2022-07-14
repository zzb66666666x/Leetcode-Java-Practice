class Solution {
    public int translateNum(int num) {
        String numStr = Integer.toString(num);
        int n = numStr.length();
        if (n == 1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=1; i<n; i++){
            dp[i+1] = dp[i];
            String sub = numStr.substring(i-1, i+1);
            if (Integer.parseInt(sub)<=25 && sub.charAt(0) != '0')
                dp[i+1] += dp[i-1];
        }
        return dp[n];
    }
}
