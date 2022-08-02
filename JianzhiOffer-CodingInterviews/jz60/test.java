class Solution {
    public double[] dicesProbability(int n) {
        if (n==1)
            return new double[]{0.16667,0.16667,0.16667,0.16667,0.16667,0.16667};
        double[][] dp = new double[n][6*n+1];
        double prob = 1.0/6.0;
        for (int i=0; i<n; i++){
            int minval = 1*(i+1);
            int maxval = 6*(i+1);
            for (int j=minval; j<=maxval; j++){
                if (i==0){
                    dp[i][j] = prob;
                }else{
                    double sum=0;
                    for (int k= Math.min(j-1, i*6); k>=i && k>=j-6; k--){
                        sum += dp[i-1][k];
                    }
                    dp[i][j] = prob*sum;
                }
            }
        }
        int minval = n;
        int maxval = 6*n;
        int idx=0;
        double[] ret = new double[maxval-minval+1];
        for (int i=minval; i<=maxval; i++){
            ret[idx++] = dp[n-1][i];
        }
        return ret;
    }
}
