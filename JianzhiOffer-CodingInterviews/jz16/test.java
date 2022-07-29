class Solution {
    public double myPow(double x, int n) {
        double ret = 1.0;
        if (n == Integer.MIN_VALUE){
            ret = 1.0/x;
            n++;
        }
        if (n<0){
            x = 1.0/x;
            n = (~n)+1;
        }
        while (n>0){
            // if (ret < -10000 || ret > 10000)
            //     return ret<0 ? -10000.0:10000.0;
            if ((n & 1) > 0){
                ret *= x;
            }
            n = n>>1;
            x = x*x;
        }
        return ret;
    }
}
