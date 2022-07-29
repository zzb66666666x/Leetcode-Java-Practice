class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        boolean bought = false;
        int low = 0;
        int high = 0;
        int ret = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i] > prices[i-1] && !bought){
                bought = true;
                low = prices[i-1];
                high = prices[i];
            }else if (prices[i] > prices[i-1] && bought){
                high = prices[i];
            }else if (prices[i] == prices[i-1]){
                continue;
            }else{// smaller price, run!
                bought = false;
                ret += (high - low);
                high = 0;
                low = 0;
            }
        }
        // still hold it? then sell it
        if (bought){
            ret += (high - low);
        }
        return ret;
    }
}
