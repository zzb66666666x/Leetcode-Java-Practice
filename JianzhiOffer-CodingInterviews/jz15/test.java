public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1<<31;
        int ret = 0;
        if ((n & mask) != 0){
            ret++;
            n = n & (~mask);
        }
        while (n != 0){
            if ((n & 1) != 0){
                ret++;
            }
            n = n >> 1;
        }
        return ret;
    }
}
