class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[] dp = new int[prices.length];
        int maxval = 0;
        for(int i=1; i<prices.length; i++){
            dp[i] = Math.max(dp[i-1] + (prices[i] - prices[i-1]), 0);
            if (dp[i] > maxval)
                maxval = dp[i];
        }
        return maxval;
    }
}
