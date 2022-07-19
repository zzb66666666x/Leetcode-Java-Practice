class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1)
            return dividend;
        int sign = 1;
        long dividendL = (long)dividend;
        long divisorL = (long)divisor;
        if (dividend < 0){
            sign = (~sign)+1;
            dividendL = -dividendL;
        }
        if (divisor < 0){
            sign = (~sign)+1;
            divisorL = -divisorL;
        }
        int ans = 0;
        for (int n=30; n>=0; n--){
            if (dividendL == 0)
                break;
            if ((1<<n) > dividendL)
                continue;
            long val = divisorL;
            int flag = 1;
            for (int i=1; i<=n; i++){
                val = val<<1;
                if (val<0 || val>dividendL){
                    flag = 0;
                    break;
                }
            }
            if (flag==1 && val<=dividendL){
                ans += (1<<n);
                dividendL -= val;
            }
            
        }
        return sign > 0 ? ans : (~ans)+1;  
    }
}
